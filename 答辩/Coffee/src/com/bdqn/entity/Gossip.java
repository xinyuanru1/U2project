package com.bdqn.entity;
/**
 * 留言实体类
 */
public class Gossip {
	
	private int gossipNo;//编号
	private String gossipTime ;//留言时间
	private String replyTime ;//回复时间
	private String gossipContent;//留言内容
	private int goods;//赞
	private int bads;//踩
	private String reply;//回复状态
	private String gossipTitle;//留言标题
	
	public String getGossipTitle() {
		return gossipTitle;
	}
	public void setGossipTitle(String gossipTitle) {
		this.gossipTitle = gossipTitle;
	}
	public String getGossipTime() {
		return gossipTime;
	}
	public void setGossipTime(String gossipTime) {
		this.gossipTime = gossipTime;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
	}
	public int getBads() {
		return bads;
	}
	public void setBads(int bads) {
		this.bads = bads;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public int getGossipNo() {
		return gossipNo;
	}
	public void setGossipNo(int gossipNo) {
		this.gossipNo = gossipNo;
	}
	public String getGossipContent() {
		return gossipContent;
	}
	public void setGossipContent(String gossipContent) {
		this.gossipContent = gossipContent;
	}
	
}
