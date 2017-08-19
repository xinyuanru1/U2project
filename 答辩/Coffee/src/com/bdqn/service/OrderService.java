package com.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Order;
/**
 * 预定
 */
public interface OrderService {
	/**
	 * 增加预定
	 */
	public int addOrderDao(Order order);
	/**
	 * 删除预定
	 */
	public int deleteOrderDao(int orderNo);
	/**
	 * 修改预定
	 */
	public int updateOrder(Order order);
	/**
	 * 预定列表
	 */
	public ArrayList<Order> getAll();
	/**
	 * 查看预定
	 */
	public Order getByNo(int orderNo);
	//计算总数
	public int getTotalCount();
	//计算当前列表
	public List<Order> getOrdees(int pageInex,int pageSize);
	/**
	 * 预定列表分类
	 */
	public List<Order> getTheOrdees(String name,int pageIndex,int pageSize);
	/**
	 * 预定信息总数
	 */
	public int getTheTotalCount(String name);
}
