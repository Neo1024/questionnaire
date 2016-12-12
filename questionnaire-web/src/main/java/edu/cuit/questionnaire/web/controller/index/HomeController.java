package edu.cuit.questionnaire.web.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date Apr 19, 2016
 *
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "index";
	}
}
