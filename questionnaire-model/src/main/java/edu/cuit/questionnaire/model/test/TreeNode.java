package edu.cuit.questionnaire.model.test;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @author lixin
 * @date May 11, 2016
 *
 */
public class TreeNode implements Serializable {

	private static final long serialVersionUID = 4282824578762298650L;

	private Situation data;

	private Map<Integer, TreeNode> childs;

	public Situation getData() {
		return data;
	}

	public void setData(Situation data) {
		this.data = data;
	}

	public Map<Integer, TreeNode> getChilds() {
		return childs;
	}

	public void setChilds(Map<Integer, TreeNode> childs) {
		this.childs = childs;
	}

}
