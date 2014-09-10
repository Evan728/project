package com.efinance.util.impl.page;

public class PageBean {
	private int page;
	
	public int getPage(){
		return this.page<1?1:page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
