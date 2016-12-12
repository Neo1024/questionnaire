package edu.cuit.questionnaire.model.test;

import java.util.Date;

import edu.cuit.questionnaire.BaseModel;

public class Operation extends BaseModel {
	private static final long serialVersionUID = -3713151604531361709L;

	private Date createDate;

	private Long testId;

	private String description;

	private int depth;

	private Long situationId;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Long getSituationId() {
		return situationId;
	}

	public void setSituationId(Long situationId) {
		this.situationId = situationId;
	}

}
