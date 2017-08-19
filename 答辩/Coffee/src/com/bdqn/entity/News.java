package com.bdqn.entity;
/**
 * 新闻实体类
 */
public class News {
	private int newsNo;//编号
	private String newsTitle;//标题
	private String newsContent;//内容
	
	public int getNewsNo() {
		return newsNo;
	}
	public void setNewsNo(int newsNo) {
		this.newsNo = newsNo;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
}
