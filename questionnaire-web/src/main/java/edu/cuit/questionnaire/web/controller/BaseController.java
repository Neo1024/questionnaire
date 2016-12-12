package edu.cuit.questionnaire.web.controller;

import org.apache.shiro.SecurityUtils;

import edu.cuit.questionnaire.model.account.User;

/**
 * 
 * @author lixin
 * @date Apr 15, 2016
 *
 */
public class BaseController {
	public User getCurrentAccount() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
