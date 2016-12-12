package edu.cuit.questionnaire.model.questionnaire;

import java.util.Date;
import java.util.List;

import edu.cuit.questionnaire.BaseModel;
import edu.cuit.questionnaire.model.account.User;

/**
 * 
 * @author lixin
 * @date Apr 22, 2016
 *
 */
public class Questionnaire extends BaseModel {

	private static final long serialVersionUID = -7614286622565337086L;

	private String title;

	private String description;

	private Date createDate;

	private User user;

	private boolean publish;

	private boolean visible;

	private long usages;

	private List<Question> questions;

	public long getUsages() {
		return usages;
	}

	public void setUsages(long usages) {
		this.usages = usages;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
