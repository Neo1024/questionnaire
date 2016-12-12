package edu.cuit.questionnaire.persist.pagination;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author leckie
 * @date May 11, 2015
 */
public class Page<E> extends ArrayList<E> implements Serializable {

	private static final long serialVersionUID = -4681262417769944853L;

	// >=0
	private long totalRows;

	// >=1
	private long totalPages;

	// >=1
	private long pageNum;

	private long pageSize;

	private long startRow;

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getStartRow() {
		return startRow;
	}

	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}

	public boolean isHasPrevious() {
		return pageNum > 1;
	}

	public boolean isHasNext() {
		return pageNum < totalPages;
	}

	public long getPrePage() {
		if (pageNum == 1) {
			return pageNum;
		}
		return pageNum - 1;
	}

	public long getNextPage() {
		if (pageNum == totalPages) {
			return pageNum;
		}
		return pageNum + 1;
	}
}
