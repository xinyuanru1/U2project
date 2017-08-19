package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.impl.GossipDaoImpl;
import com.bdqn.entity.Gossip;
import com.bdqn.service.GossipService;

public class GossipServiceImpl implements GossipService{

	GossipDaoImpl gossipDaoImpl;
	/**
	 * 构造方法
	 */
	public GossipServiceImpl(){
		gossipDaoImpl = new GossipDaoImpl();
	}
	/**
	 * 添加留言
	 */
	public int addGossipDao(Gossip gossip) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.addGossipDao(gossip);
	}
	/**
	 * 删除留言
	 */
	public int deleteGossipDao(int gossipNo) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.deleteGossipDao(gossipNo);
	}
	/**
	 * 留言列表
	 */
	public ArrayList<Gossip> getAll() {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getAll();
	}
	/**
	 *查看留言（根据编号） 
	 */
	public Gossip getByNo(int gossipNo) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getByNo(gossipNo);
	}
	/**
	 * 修改留言
	 */
	public int update(Gossip gossip) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.update(gossip);
	}
	/**
	 * 留言列表分页
	 */
	public List<Gossip> getGossips(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getGossips(pageIndex, pageSize);
	}
	/**
	 *留言总数 
	 */
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getTotalCount();
	}
	/**
	 * 分页（根据键值）
	 */
	public List<Gossip> getSome(String key, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getSome(key, pageIndex, pageSize);
	}
	/**
	 * 留言总数（根据键值）
	 */
	public int getSomeTotalCount(String key) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.getSomeTotalCount(key);
	}
	/**
	 * 添加赞
	 */
	public int addBads(Gossip gossip) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.addBads(gossip);
	}
	/**
	 * 添加踩
	 */
	public int addGoods(Gossip gossip) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.addGoods(gossip);
	}
	/**
	 * 增加回复
	 */
	public int addReply(Gossip gossip, String reply) {
		// TODO Auto-generated method stub
		return gossipDaoImpl.addReply(gossip, reply);
	}

}
