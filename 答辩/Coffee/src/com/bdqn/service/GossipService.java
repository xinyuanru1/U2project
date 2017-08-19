package com.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Gossip;

public interface GossipService {
	/**
	 * 添加留言
	 */
	public int addGossipDao(Gossip Gossip);
	/**
	 * 删除留言
	 */
	public int deleteGossipDao(int gossipNo);
	/**
	 * 修改留言
	 */
	public int update(Gossip Gossip);
	/**
	 * 留言列表
	 */
	public ArrayList<Gossip> getAll();
	/**
	 * 查看留言
	 */
	public Gossip getByNo(int gossipNo);
	//计算总数
	public int getTotalCount();
	//计算当前页列表
	public List<Gossip> getGossips(int pageIndex,int pageSize);	
	/**
	 * 根据参数返回留言列表
	 */
	public List<Gossip> getSome(String key,int pageIndex, int pageSize);
	/**
	 * 留言总数
	 */
	public int getSomeTotalCount(String key);
	/**
	 * 添加赞
	 */
	public int addGoods(Gossip gossip);
	/**
	 * 增加踩
	 */
	public int addBads(Gossip gossip);
	/**
	 * 添加回复
	 */
	public int addReply(Gossip gossip,String reply);

}
