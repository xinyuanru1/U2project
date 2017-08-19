package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Gossip;

public interface GossipDao {
	/**
	 * 增加留言信息
	 * @param Gossip
	 * @return int值
	 */
	public int addGossipDao(Gossip Gossip);
	/*
	 * 删除留言信息表
	 * return int 
	 */
	public int deleteGossipDao(int gossipNo);
	/*
	 * 更新留言信息表
	 * return int
	 */
	public int update(Gossip Gossip);
	/*
	 * 查询留言信息列表
	 */
	public ArrayList<Gossip> getAll();
	/**
	 * 分页列表
	 * @param key
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Gossip> getSome(String key,int pageIndex, int pageSize);
	/**
	 * 根据留言Id查询留言信息
	 * @param gossipNo
	 * @return
	 */
	public Gossip getByNo(int gossipNo);
	//计算总数
	public int getTotalCount();
	//计算当前页列表
	public List<Gossip> getGossips(int pageIndex,int pageSize);
	/*
	 *
	 */
	public int getSomeTotalCount(String key);
	/**
	 * 赞
	 * @param gossip
	 * @return
	 */
	public int addGoods(Gossip gossip);
	/**
	 * 踩
	 * @param gossip
	 * @return
	 */
	public int addBads(Gossip gossip);
	/**
	 * 添加回复信息
	 * @param gossip
	 * @param reply
	 * @return
	 */
	public int addReply(Gossip gossip,String reply);
}
