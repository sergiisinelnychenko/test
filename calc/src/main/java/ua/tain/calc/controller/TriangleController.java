package ua.tain.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;

/**
 * Spring controller to calculate Triangle area
 * @author polar
 *
 */
@Controller
@RequestMapping("/triangle.ca")
public class TriangleController extends BaseController {

	/**
	 * Calculates area for Triangle. Assumes three parameters - three different sides
	 * @param fields
	 * @return Area of the Triangle
	 */
	protected double calculateResult(Pair[] fields) {
		double p = (fields[0].getValue() + fields[1].getValue() + fields[2].getValue() ) / 2;
		return Math.sqrt(p * (p - fields[0].getValue())* (p - fields[1].getValue())* (p - fields[2].getValue()));
	}

	/**
	 * Returns localized shape name
	 */
	protected String getShapeNameCode() {
		return "msg.triangle.name";
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	@Override
	protected Data getData() {
		return new Data(new Pair[] { 
				new Pair(messageResourceBundle.getMessage("msg.triangle.side1", currentLocale), 5),
				new Pair(messageResourceBundle.getMessage("msg.triangle.side2", currentLocale), 5),
				new Pair(messageResourceBundle.getMessage("msg.triangle.side3", currentLocale), 5) });
	}
}
