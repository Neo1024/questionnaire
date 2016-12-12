package edu.cuit.questionnaire.model.questionnaire;

import java.sql.Date;
import java.util.List;

import edu.cuit.questionnaire.BaseModel;

/**
 * 
 * @author lixin
 * @date Apr 22, 2016
 *
 */
public class Question extends BaseModel {

	private static final long serialVersionUID = -3195036785294408963L;

	private String title;

	private Date createDate;

	private Long questionnaireId;

	private int type;

	private List<Option> options;

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

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

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
