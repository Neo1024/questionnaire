package edu.cuit.questionnaire.model.questionnaire;

import java.util.Date;

import edu.cuit.questionnaire.BaseModel;

/**
 * 
 * @author lixin
 * @date Apr 22, 2016
 *
 */
public class Option extends BaseModel {

	private static final long serialVersionUID = 4147599679189992079L;

	private String title;

	private Date createDate;

	private Long questionId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}
