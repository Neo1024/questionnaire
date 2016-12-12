package edu.cuit.questionnaire;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = -8687683226030522130L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
