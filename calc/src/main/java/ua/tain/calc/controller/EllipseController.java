package ua.tain.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;

/**
 * Spring controller to calculate Ellipse area
 * @author polar
 *
 */
@Controller
@RequestMapping("/ellipse.ca")
public class EllipseController extends BaseController {

	/**
	 * Calculates area for Ellipse. Assumes the two parameters - two radiuses
	 * @param fields
	 * @return Area of the ellipse
	 */
	protected double calculateResult(Pair[] fields) {
		return fields[0].getValue() * fields[1].getValue() * Math.PI;
	}

	/**
	 * Returns localized shape name
	 */
	protected String getShapeNameCode() {
		return "msg.ellipse.name";
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	@Override
	protected Data getData() {
		return new Data(new Pair[] { 
				new Pair(messageResourceBundle.getMessage("msg.ellipse.side1", currentLocale), 5),
				new Pair(messageResourceBundle.getMessage("msg.ellipse.side2", currentLocale), 3) });
	}

}
