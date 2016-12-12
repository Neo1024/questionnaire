package edu.cuit.questionnaire.model.account;

import edu.cuit.questionnaire.BaseModel;

/**
 * 
 * @author lixin
 * @date Apr 16, 2016
 *
 */
public class User extends BaseModel {

	private static final long serialVersionUID = 4458282407245460640L;

	private String name;

	private String email;

	private String passwd;

	private String salt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
