package edu.cuit.questionnaire.service.account;

import edu.cuit.questionnaire.model.account.User;
import edu.cuit.questionnaire.service.BaseService;

/**
 * 
 * @author lixin
 * @date Apr 16, 2016
 *
 */
public interface UserService extends BaseService {
	public void register(User user);
	
	public boolean checkPasswd(String email, String passwd);

	public User findByEmail(String email);
}
