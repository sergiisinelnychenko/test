package ua.tain.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;

/**
 * Spring controller to calculate Square area
 * @author polar
 *
 */
@Controller
@RequestMapping("/square.ca")
public class SquareController extends BaseController {

	/**
	 * Calculates area for Square. Assumes the only parameter - side length
	 * @param fields
	 * @return Area of the Square
	 */
	protected double calculateResult(Pair[] fields) {
		return fields[0].getValue() * fields[0].getValue();
	}

	/**
	 * Returns localized shape name
	 */
	protected String getShapeNameCode() {
		return "msg.square.name";
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	@Override
	protected Data getData() {
		return new Data(new Pair[] { new Pair(messageResourceBundle.getMessage("msg.square.side", currentLocale), 5) });
	}

}
