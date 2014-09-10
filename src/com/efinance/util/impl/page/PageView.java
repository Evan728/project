package com.efinance.util.impl.page;

import java.util.List;
public class PageView<T> {
	
	/** 锟斤拷页锟斤拷锟�**/
	private List<T> records;
	
	/** 页锟诫开始锟斤拷锟斤拷徒锟斤拷锟斤拷锟斤拷锟�**/
	private PageIndex pageIndex;
	
	/** 锟斤拷页锟斤拷 **/
	private long totalPage = 1;
	
	/** 每页锟斤拷示锟斤拷录锟斤拷 **/
	private int maxResult = 15;
	
	/** 锟斤拷前页 **/
	private int currentPage = 1;
	
	/** 锟杰硷拷录锟斤拷 **/
	private long totalRecord;
	
	/** 页锟斤拷锟斤拷锟斤拷 **/
	private int pageCode = 5;
	
	/** 要锟斤拷取锟斤拷录锟侥匡拷始锟斤拷锟斤拷 **/
	public int getFirstResult() {
		return (this.currentPage-1)*this.maxResult;
	}
	
	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	//锟斤拷锟斤拷锟斤拷,每页锟斤拷示锟斤拷锟斤拷锟斤拷锟斤拷录锟斤拷锟斤拷前页
	public PageView(int maxResult, int currentPage) {
		this.maxResult = maxResult;
		this.currentPage = currentPage;
	}
	
	public void setResultType(ResultType<T> rt){
		setTotalRecord(rt.getTotalRecord());
		setRecords(rt.getResultList());
	}
	
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord%this.maxResult==0? this.totalRecord/this.maxResult : this.totalRecord/this.maxResult+1);
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public PageIndex getPageIndex() {
		return pageIndex;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
		this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage, totalPage);
	}
	public int getMaxResult() {
		return maxResult;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	
}
