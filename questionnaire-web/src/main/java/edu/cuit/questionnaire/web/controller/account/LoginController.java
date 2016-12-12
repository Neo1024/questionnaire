package edu.cuit.questionnaire.web.controller.account;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cuit.questionnaire.web.controller.BaseController;

/**
 * 
 * @author lixin
 * @date Apr 15, 2016
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@RequestMapping(method = RequestMethod.GET)
	public String toLoginPage() {
		return "account/login";
	}
	
    @RequestMapping(method = RequestMethod.POST)
    public String loginFail(
            @RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String name,
            HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String message = null;
        String redirectUrl = null;

        // UnknownAccountException || IncorrectCredentialsException
        message = "用户名或密码错误";
        redirectUrl = "redirect:/login";

        redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute(
                FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, name);
        return redirectUrl;
    }
}
