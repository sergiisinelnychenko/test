package ua.tain.calc.controller;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;
import ua.tain.calc.util.MessageResourceBundle;

/**
 * This is base Controller class, which provides all common functionality for
 * area calculation controllers. It is responsible for data retrieval and
 * processing and validation, and delegates to children only unique
 * functionality - shape names, area calculations etc
 * 
 * @author polar
 * 
 */
public abstract class BaseController {

	/**
	 * Message source, for string externalization and i18n
	 */
	@Resource
	protected MessageResourceBundle messageResourceBundle;

	/**
	 * Current request locale, for proper message retrieval
	 */
	protected Locale currentLocale;


	/**
	 * Simple public constructor
	 */
	public BaseController() {
		super();
	}

	/**
	 * Invoked to display data - regardless, did we calculate already area or
	 * not
	 * 
	 * @param model
	 *            Model to pass to View
	 * @param request
	 *            Current HTTP request, used to retrieve Locale only
	 * @return Returns view form - which JSP to redirect to
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String show(Model model, HttpServletRequest request) {
		currentLocale = request.getLocale();
		model.addAttribute("data", getData());
		model.addAttribute("shapeName", getShapeName());
		model.addAttribute("contextName", request.getContextPath());
		return "form";
	}

	/**
	 * Invoked on POST query, when we need to calculate area. Uses form input
	 * validation - for user-friendly input validation
	 * 
	 * @param model
	 *            Model to pass to View
	 * @param request
	 *            Current HTTP request, used to retrieve Locale only
	 * @param data
	 *            Form data submitted
	 * @param binding
	 *            Binding results. For now - we are just interesting, were there
	 *            any errors at all or not
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("data") @Valid Data data, final BindingResult binding,
			HttpServletRequest request) {
		currentLocale = request.getLocale();
		if (binding.hasErrors()) {
			model.addAttribute("prevCalcMsg", messageResourceBundle.getMessage("msg.typeError", currentLocale));
			return show(model, request);
		}
		double res = 0;
		if (data != null) {
			Pair[] fields = data.getFields();
			if (fields != null) {
				res = calculateResult(fields);
			}
		}
		
		model.addAttribute("prevCalcMsg", messageResourceBundle.getMessage("msg.square.result", currentLocale, res));
		
		increaseCalculation(getShapeNameCode());
		
		return show(model, request);
	}

	/**
	 * Increases number of calculations for specified shape
	 * @param shapeNameCode
	 */
	protected void increaseCalculation(String shapeNameCode) {
		String v = IndexController.storage.getProperty(shapeNameCode);
		long i = 0;
		if ((v != null) && (v.length()>0)) {
			i = Long.parseLong(v);
		}
		IndexController.storage.put(shapeNameCode, (new Long(i+1)).toString());
		flushStorage();
	}

	/**
	 * Flushes data to disk
	 */
	protected void flushStorage() {
		try {
			IndexController.storage.list(new PrintStream("shapes.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	protected abstract Data getData();

	/**
	 * Returns localized shape name
	 */
	protected String getShapeName() {
		return messageResourceBundle.getMessage(getShapeNameCode(), currentLocale);
	}

	/**
	 * Returns shape name code
	 */
	protected abstract String getShapeNameCode();

	/**
	 * Calculates area according to parameters passed. Each shape has its own algorithm
	 */
	protected abstract double calculateResult(Pair[] fields);

}