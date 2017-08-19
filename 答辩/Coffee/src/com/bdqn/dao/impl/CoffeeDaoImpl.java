package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.bdqn.dao.CoffeeDao;
import com.bdqn.entity.Coffee;
/**
 * CoffeeDao的实现类，对咖啡进行数据库的操作
 * @author xinyuanru1
 *
 */
public class CoffeeDaoImpl extends BaseDaoImpl implements CoffeeDao{

	/**
	 * 按分页形式得到Coffee集合
	 */
	public List<Coffee> getNews(int pageIndex, int pageSize) {

		List<Coffee> coffees = new ArrayList<Coffee>();
		int start = (pageIndex-1)*pageSize;
		String sql ="SELECT * FROM coffee ORDER BY coffeeNo desc LIMIT ?,?";
		Object [] params ={start,pageSize};
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				Coffee coffee = new Coffee();
				coffee.setCoffeeNo(rs.getInt(1));
				coffee.setCoffeeName(rs.getString(2));
				coffee.setCoffeePrice(rs.getString(3));
				coffee.setCoffeeType(rs.getString(4));
				coffee.setPicPath(rs.getString(5));
			
				coffees.add(coffee);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		return coffees;
	}
	/**
	 * 得到Coffee总数
	 */
	public int getTotalCount() {
		int totalCount=0;
		Object[] params ={};
		String sql ="select count(*) from coffee";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				totalCount=rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		
		return totalCount;
	}
	/**
	 * 增加Coffee
	 */
	public int addCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		int flag=0;
		String sql="INSERT INTO `coffee`.`coffee` (`coffeeName`, `coffeePrice`, `coffeeType`,`picPath`) VALUES (?,?,?,?);" ;
		Object[] params={coffee.getCoffeeName(),coffee.getCoffeePrice(),coffee.getCoffeeType(),coffee.getPicPath()};
		flag = this.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 根据coffeeNo（主键）删除Coffee
	 */
	public int deleteCoffee(int coffeeNo) {
		// TODO Auto-generated method stub
		int flag=0;
		String sql="DELETE FROM `coffee`.`coffee` WHERE `coffeeNo` =?;";
		Object[] params={coffeeNo};
		flag=super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 得到所有Coffee集合
	 */
	public List<Coffee> getAll() {
		// TODO Auto-generated method stub
		List<Coffee> coffees = new ArrayList<Coffee>();
		String sql = "select * from coffee.coffee";
		Object[] pare = {};
		resultSet = executeQuery(sql, pare);
		try {
			while(resultSet.next()){
					Coffee coffee = new Coffee();
					coffee.setCoffeeName(resultSet.getString("coffeeName"));
					coffee.setCoffeeNo(resultSet.getInt("coffeeNo"));
					coffee.setCoffeePrice(resultSet.getString("coffeePrice"));
					coffee.setCoffeeType(resultSet.getString("coffeeType"));
					coffee.setPicPath(resultSet.getString("picPath"));
					coffees.add(coffee);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coffees;
	}
	/**
	 * 修改Coffee各项数据，CoffeeNo（主键）不可修改
	 */
	public int updateCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql ="UPDATE `coffee`.`coffee` SET `coffeeType` =?, `coffeeName` =?, `coffeePrice` =?,picPath=? WHERE `coffeeNo` =?; ";
		Object[] params = {coffee.getCoffeeType(),coffee.getCoffeeName(),coffee.getCoffeePrice(),coffee.getPicPath(),coffee.getCoffeeNo()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 根据coffeeNo得到Coffee实体
	 */
	public Coffee getCoffeeByNo(int coffeeNo) {
		// TODO Auto-generated method stub
		Coffee coffee = new Coffee();
		String sql = "SELECT * FROM coffee.coffee WHERE `coffeeNo` = ? ";
		Object[] pare = {coffeeNo};
		resultSet = executeQuery(sql, pare);
		try {
			while(resultSet.next()){
					coffee.setCoffeeName(resultSet.getString("coffeeName"));
					coffee.setCoffeeNo(resultSet.getInt("coffeeNo"));
					coffee.setCoffeePrice(resultSet.getString("coffeePrice"));
					coffee.setCoffeeType(resultSet.getString("coffeeType"));
					coffee.setPicPath(resultSet.getString("picPath"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coffee;
	}
	//根据名称返回咖啡实体
	public Coffee getCoffeeByNo(String coffeeName) {
		Coffee coffee = new Coffee();
		String sql = "SELECT * FROM coffee.coffee WHERE `coffeeName` = ? ";
		Object[] pare = {coffeeName};
		resultSet = executeQuery(sql, pare);
		try {
			while(resultSet.next()){
					coffee.setCoffeeName(resultSet.getString("coffeeName"));
					coffee.setCoffeeNo(resultSet.getInt("coffeeNo"));
					coffee.setCoffeePrice(resultSet.getString("coffeePrice"));
					coffee.setCoffeeType(resultSet.getString("coffeeType"));
					coffee.setPicPath(resultSet.getString("picPath"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coffee;
		
	}
	public List<Coffee> getByType(int pageIndex, int pageSize, String type) {

		List<Coffee> coffees = new ArrayList<Coffee>();
		int start = (pageIndex-1)*pageSize;
		String sql ="SELECT * FROM coffee where `coffeeType` = ? ORDER BY coffeeNo desc LIMIT ?,?";
		Object [] params ={type,start,pageSize};
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(rs.next()){
				Coffee coffee = new Coffee();
				coffee.setCoffeeNo(rs.getInt(1));
				coffee.setCoffeeName(rs.getString(2));
				coffee.setCoffeePrice(rs.getString(3));
				coffee.setCoffeeType(rs.getString(4));
				coffee.setPicPath(rs.getString(5));
			
				coffees.add(coffee);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			super.closeConnection();
		}
		return coffees;
	}
}

