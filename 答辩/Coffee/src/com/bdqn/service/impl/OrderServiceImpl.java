package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.impl.OrderDaoImpl;
import com.bdqn.entity.Order;
import com.bdqn.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderDaoImpl orderDaoImpl = null;
	/**
	 * 构造方法
	 */
	public OrderServiceImpl(){
		orderDaoImpl = new OrderDaoImpl();
	}
	/**
	 * 添加预定
	 */
	public int addOrderDao(Order order) {
		// TODO Auto-generated method stub
		return orderDaoImpl.addOrderDao(order);
	}
	/**
	 * 删除预定
	 */
	public int deleteOrderDao(int orderNo) {
		// TODO Auto-generated method stub
		return orderDaoImpl.deleteOrderDao(orderNo);
	}
	/**
	 *预定列表 
	 */
	public ArrayList<Order> getAll() {
		// TODO Auto-generated method stub
		return orderDaoImpl.getAll();
	}
	/**
	 * 查看预定
	 */
	public Order getByNo(int orderNo) {
		// TODO Auto-generated method stub
		return orderDaoImpl.getByNo(orderNo);
	}
	/**
	 * 修改预定 
	 */
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDaoImpl.updateOrder(order);
	}
	/**
	 * 分页列表
	 */
	public List<Order> getOrdees(int pageInex, int pageSize) {
		// TODO Auto-generated method stub
		return orderDaoImpl.getOrdees(pageInex, pageSize);
	}
	/**
	 * 预定信息总数
	 */
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return orderDaoImpl.getTotalCount();
	}
	/**
	 * 分页（按用户名）
	 */
	public List<Order> getTheOrdees(String name, int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return orderDaoImpl.getTheOrdees(name, pageIndex, pageSize);
	}
	/**
	 * 信息总数（按用户名）
	 */
	public int getTheTotalCount(String name) {
		// TODO Auto-generated method stub
		return orderDaoImpl.getTheTotalCount(name);
	}

}
