package edu.cuit.questionnaire.model.answer;

import java.util.Date;
import java.util.List;

import edu.cuit.questionnaire.BaseModel;
import edu.cuit.questionnaire.model.questionnaire.Questionnaire;

/**
 * 
 * @author lixin
 * @date May 9, 2016
 *
 */
public class Sheet extends BaseModel {

	private static final long serialVersionUID = 1620469638911668002L;

	private Long questionnaireId;

	private Long userId;

	private Date createDate;

	private List<Answer> answers;

	private Questionnaire questionnaire;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
