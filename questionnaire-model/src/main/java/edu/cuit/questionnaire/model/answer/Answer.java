package edu.cuit.questionnaire.model.answer;

import java.util.Date;
import java.util.List;

import edu.cuit.questionnaire.BaseModel;
import edu.cuit.questionnaire.model.questionnaire.Question;

/**
 * 
 * @author lixin
 * @date May 9, 2016
 *
 */
public class Answer extends BaseModel {

	private static final long serialVersionUID = 6805923122907825220L;

	private Long sheetId;

	private Long questionId;

	private Date createDate;

	private String answer;

	private Question question;

	private int type;

	private List<Integer> multipleChoices;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getSheetId() {
		return sheetId;
	}

	public void setSheetId(Long sheetId) {
		this.sheetId = sheetId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Integer> getMultipleChoices() {
		return multipleChoices;
	}

	public void setMultipleChoices(List<Integer> multipleChoices) {
		this.multipleChoices = multipleChoices;
	}

}
