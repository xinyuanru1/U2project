package com.bdqn.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.OrderDao;
import com.bdqn.entity.Order;
/**
 * OrderDao的实现类，对订单进行数据库的操作
 * @author xinyuanru1
 *
 */
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao{

	/**
	 * 按分页形式得到Order集合
	 */
	public List<Order> getOrdees(int pageIndex, int pageSize) {
		List<Order> orders = new ArrayList<Order>();
		int start =(pageIndex-1)*pageSize;
		Object[] params={start,pageSize};
		String sql ="SELECT * FROM `order` ORDER BY orderNo LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				Order order = new Order();
				order.setOrderNo(rs.getInt(1));
				order.setOrderName(rs.getString(2));
				order.setOrderPhone(rs.getString(3));
				order.setOrderTime(rs.getString(4));
				order.setOrderNum(rs.getInt(5));
				orders.add(order);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{

			super.closeConnection();
		}
		

		return orders;
	}

	/**
	 * 得到Order总数
	 */
	public int getTotalCount() {
		int totalCount=0;
		Object[] params ={};
		String sql ="SELECT COUNT(*) FROM `order`";
		ResultSet rs =super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		
		return totalCount;
	}
	/**
	 * 增加Order
	 */
	public int addOrderDao(Order order) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "INSERT INTO `coffee`.`order` (`orderName`, `orderPhone`, `orderTime`, `orderNum`) VALUES (?,?,?,?); ";
		Object[] params = {order.getOrderName(),order.getOrderPhone(),order.getOrderTime(),order.getOrderNum()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	
	/**
	 * 根据orderNo（主键）删除Order
	 */
	public int deleteOrderDao(int orderNo) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "DELETE FROM `coffee`.`order` WHERE `orderNo` = ?;";
		Object[] params = {orderNo};
		flag = super.executeUpdate(sql, params);
		return flag;
	}

	/**
	 * 得到所有Order集合
	 */
	public ArrayList<Order> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		String sql = "select * from coffee.order";
		try {
			getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Order order = new Order();
				order.setOrderName(resultSet.getString("orderName"));
				order.setOrderNo(resultSet.getInt("orderNo"));
				order.setOrderNum(resultSet.getInt("orderNum"));
				order.setOrderPhone(resultSet.getString("orderPhone"));
				order.setOrderTime(resultSet.getString("orderTime"));
				orders.add(order);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	/**
	 * 根据orderNo得到Order实体
	 */
	public Order getByNo(int orderNo) {
		// TODO Auto-generated method stub
		Order order = null;
		String sql = "select * from coffee.order where orderNo = ?";
		Object[] params = {orderNo};
		try {
			resultSet = super.executeQuery(sql, params);
			while(resultSet.next()){
				order = new Order();
				order.setOrderName(resultSet.getString("orderName"));
				order.setOrderNo(resultSet.getInt("orderNo"));
				order.setOrderNum(resultSet.getInt("orderNum"));
				order.setOrderPhone(resultSet.getString("orderPhone"));
				order.setOrderTime(resultSet.getString("orderTime"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}

	/**
	 * 修改Order各项数据，orderNo（主键）不可修改
	 */
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "UPDATE `coffee`.`order` SET `orderName` = ? , `orderPhone` = ? , `orderTime` = ? , `orderNum` = ? WHERE `orderNo` = ?; ";
		Object[] params = {order.getOrderName(),order.getOrderPhone(),order.getOrderTime(),order.getOrderNum(),order.getOrderNo()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	//前台分页
	public List<Order> getTheOrdees(String name, int pageIndex, int pageSize) {
		List<Order> orders = new ArrayList<Order>();
		int start =(pageIndex-1)*pageSize;
		Object[] params={name,start,pageSize};
		String sql ="SELECT * FROM `order` where orderName = ? ORDER BY orderNo desc LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				Order order = new Order();
				order.setOrderNo(rs.getInt(1));
				order.setOrderName(rs.getString(2));
				order.setOrderPhone(rs.getString(3));
				order.setOrderTime(rs.getString(4));
				order.setOrderNum(rs.getInt(5));
				orders.add(order);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		return orders;
	}
	public int getTheTotalCount(String name) {
		int totalCount=0;
		Object[] params ={name};
		String sql ="SELECT COUNT(*) FROM `order` where orderName = ?";
		ResultSet rs =super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		
		return totalCount;
	}
	
}
