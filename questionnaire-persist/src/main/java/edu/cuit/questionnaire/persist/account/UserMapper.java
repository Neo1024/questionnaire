package edu.cuit.questionnaire.persist.account;

import edu.cuit.questionnaire.model.account.User;
import edu.cuit.questionnaire.persist.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
	
	public User findByEmail(String email);
}
