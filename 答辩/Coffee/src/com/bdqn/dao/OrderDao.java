package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Gossip;
import com.bdqn.entity.Order;
/**
 * 客户预定接口
 */
public interface OrderDao {
	/**
	 * 添加订单
	 */
	public int addOrderDao(Order order);
	/**
	 * 删除订单
	 */
	public int deleteOrderDao(int orderNo);
	/**
	 * 修改订单
	 */
	public int updateOrder(Order order);
	/**
	 * 订单列表
	 */
	public ArrayList<Order> getAll();
	/**
	 * 查看订单
	 */
	public Order getByNo(int orderNo);
	//计算总数
	public int getTotalCount();
	//计算当前列表
	public List<Order> getOrdees(int pageIndex,int pageSize);
	//前台分页
	public List<Order> getTheOrdees(String name,int pageIndex,int pageSize);
	
	public int getTheTotalCount(String name);
	
}
