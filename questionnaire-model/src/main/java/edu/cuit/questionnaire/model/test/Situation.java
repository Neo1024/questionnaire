package edu.cuit.questionnaire.model.test;

import java.util.Date;
import java.util.List;

import edu.cuit.questionnaire.BaseModel;

public class Situation extends BaseModel {
	private static final long serialVersionUID = -4830651494440834873L;

	private Date createData;
	
	private Long testId;
	
	private String description;
	
	private int score;
	
	private boolean pivotal;
	
	private int depth;
	
	private int standardSteps;
	
	private List<Operation> operations;

	public Date getCreateData() {
		return createData;
	}

	public void setCreateData(Date createData) {
		this.createData = createData;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isPivotal() {
		return pivotal;
	}

	public void setPivotal(boolean pivotal) {
		this.pivotal = pivotal;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getStandardSteps() {
		return standardSteps;
	}

	public void setStandardSteps(int standardSteps) {
		this.standardSteps = standardSteps;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
