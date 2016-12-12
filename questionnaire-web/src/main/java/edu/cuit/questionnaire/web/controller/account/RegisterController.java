package edu.cuit.questionnaire.web.controller.account;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cuit.questionnaire.model.account.User;
import edu.cuit.questionnaire.service.account.UserService;
import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date Apr 15, 2016
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String toRegisterPage() {
		return "account/register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid User user) {
		userService.register(user);
		return "index";
	}
}
