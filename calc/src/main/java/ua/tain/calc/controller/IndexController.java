package ua.tain.calc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Spring controller to display Index page
 * 
 * @author polar
 * 
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	public static Properties storage;
	/**
	 * Does almost nothing - just forwards to index page. Exist for possible
	 * future use
	 * 
	 * @param model
	 *            Model to pass to View
	 * @return View name to forward to
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String root(Model model) {
		model.addAttribute("storage", storage);
		return "index";
	}
	public IndexController() {
		super();
		storage = new Properties();
		try {
			storage.load(new FileInputStream("shapes.properties"));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

}
