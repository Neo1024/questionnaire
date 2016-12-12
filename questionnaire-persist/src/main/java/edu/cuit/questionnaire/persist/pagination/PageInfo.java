package edu.cuit.questionnaire.persist.pagination;

import java.io.Serializable;

/**
 * 
 * @author Leckie<xianbo.lai@ixix.im>
 * @date May 18, 2015
 * @version 2.0
 */
public class PageInfo implements Serializable {

	private static final long serialVersionUID = 7105860314033813239L;

	public static final long DEFAULT_PAGE_SIZE = 10;

	public static final long DEFAULT_PAGE_NUM = 1;

	public static final long DEFAULT_TOTAL_ROWS = 0;

	private long pageNum;

	private long pageSize;

	private long totalRows;

	private String sortKey;

	public PageInfo() {
		this(DEFAULT_PAGE_NUM, DEFAULT_PAGE_SIZE, DEFAULT_TOTAL_ROWS);
	}

	public PageInfo(long pageNum) {
		this(pageNum, DEFAULT_PAGE_SIZE, DEFAULT_TOTAL_ROWS);
	}

	public PageInfo(long pageNum, long pageSize) {
		this(pageNum, pageSize, DEFAULT_TOTAL_ROWS);
	}

	public PageInfo(long pageNum, long pageSize, long totalRows) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRows = totalRows;
	}

	/**
	 * 获取第一条记录行数<br>
	 * 
	 * @return
	 */
	public long getStartRow() {
		if (totalRows <= 0) {
			return 0;
		}
		long totalPages = getTotalPages();
		if (pageNum > totalPages) {
			// 当前页数超出总页数时, 返回最后一页
			pageNum = totalPages;
		}
		// 分页合理化
		if (pageNum <= 0) {
			pageNum = 1;
		}
		return (pageNum - 1) * pageSize;
	}

	/**
	 * 计算总页数<br>
	 * 
	 * @return
	 */
	public long getTotalPages() {
		if (totalRows == 0) {
			return 1;
		}
		return (totalRows + pageSize - 1) / pageSize;
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

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

}
