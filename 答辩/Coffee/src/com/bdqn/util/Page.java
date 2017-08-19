package com.bdqn.util;

import java.util.List;

public class Page<T> {
	private int currentIndex;
	private int totalCount;
	private int pageTotalCount;
	private int pageSize;
	private List<T> pageList;
	public int getCurrentIndex() {
		return currentIndex;
	}
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
		this.totalCount = totalCount;
		this.pageTotalCount=(this.totalCount%this.pageSize==0)?(this.totalCount/this.pageSize):(this.totalCount/this.pageSize+1);
		}
		}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	
	
}
