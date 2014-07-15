package ua.tain.calc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.tain.calc.model.Data;
import ua.tain.calc.model.Pair;

/**
 * Spring controller to calculate Circle area
 * @author polar
 *
 */
@Controller
@RequestMapping("/circle.ca")
public class CircleController extends BaseController {

	/**
	 * Calculates area for Circle. Assumes the only parameter - radius
	 * @param fields
	 * @return Area of the circle
	 */
	protected double calculateResult(Pair[] fields) {
		return fields[0].getValue() * fields[0].getValue() * Math.PI;
	}

	/**
	 * Returns localized shape name
	 */
	protected String getShapeNameCode() {
		return "msg.circle.name";
	}

	/**
	 * Prepares shape-dependent data set - number of fields and their default values
	 */
	@Override
	protected Data getData() {
		return new Data(new Pair[] { new Pair(messageResourceBundle.getMessage("msg.circle.radius", currentLocale), 5) });
	}

}
