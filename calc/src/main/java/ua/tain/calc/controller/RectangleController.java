package ua.tain.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;

/**
 * Spring controller to calculate Rectangle area
 * @author polar
 *
 */
@Controller
@RequestMapping("/rectangle.ca")
public class RectangleController extends BaseController {

	/**
	 * Calculates area for Rectangle. Assumes two parameters - length of sides
	 * @param fields
	 * @return Area of the rectangle
	 */
	protected double calculateResult(Pair[] fields) {
		return fields[0].getValue() * fields[1].getValue();
	}

	/**
	 * Returns localized shape name
	 */
	protected String getShapeNameCode() {
		return "msg.rectangle.name";
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	@Override
	protected Data getData() {
		return new Data(new Pair[] { 
				new Pair(messageResourceBundle.getMessage("msg.rectangle.side1", currentLocale), 5),
				new Pair(messageResourceBundle.getMessage("msg.rectangle.side2", currentLocale), 3) });
	}

}
