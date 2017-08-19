package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.MenuDao;
import com.bdqn.entity.Menu;

public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {
	/**
	 * 添加订单
	 */
	public int addMenu(Menu menu) {
		int flag = 0;
		String sql = "INSERT INTO `coffee`.`menu` (`userName`, `proName`, `proPrice`,userPhone,userAddress,menuStatu,proNum,proTotalPrice) VALUES (?,?,?,?,?,?,?,?); ";
		Object[] params = {menu.getUserName(),menu.getProName(),menu.getProPrice(),menu.getUserPhone(),menu.getUserAddress(),menu.getMenuStatu(),menu.getProNum(),menu.getProTotalPrice()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 删除订单
	 */
	public int deleteMenu(int menuNo) {
		int flag = 0;
		String sql = "DELETE FROM coffee.`menu` WHERE `menuNo` = ?;" ;
		Object[] params = {menuNo};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 查看订单
	 */
	public Menu getByNo(int menuNo) {
		Menu menu = null;
		String sql = "SELECT * FROM coffee.`menu` WHERE `menuNo` = ?";
		Object[] params = {menuNo};
		resultSet = super.executeQuery(sql, params);
		try {
			while(resultSet.next()){
				menu = new Menu();
				menu.setMenuNo(menuNo);
				menu.setProName(resultSet.getString("proName"));
				menu.setProPrice(resultSet.getString("proPrice"));
				menu.setUserName(resultSet.getString("userName"));
				menu.setUserPhone(resultSet.getString("userPhone"));
				menu.setUserAddress(resultSet.getString("userAddress"));
				menu.setMenuStatu(resultSet.getString("menuStatu"));
				menu.setProNum(resultSet.getInt("proNum"));
				menu.setProTotalPrice(resultSet.getString("proTotalPrice"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	/**
	 * 订单分页
	 */
	public List<Menu> getMenus(int pageIndex, int pageSize) {
		List<Menu> menus = new ArrayList<Menu>();
		int start =(pageIndex-1)*pageSize;
		Object[] params={start,pageSize};
		String sql ="SELECT * FROM `menu` ORDER BY menuNo desc LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(resultSet.next()){
				Menu menu = new Menu();
				menu.setMenuNo(resultSet.getInt(1));
				menu.setProName(resultSet.getString("proName"));
				menu.setProPrice(resultSet.getString("proPrice"));
				menu.setUserName(resultSet.getString("userName"));
				menu.setUserPhone(resultSet.getString("userPhone"));
				menu.setUserAddress(resultSet.getString("userAddress"));
				menu.setMenuStatu(resultSet.getString("menuStatu"));
				menu.setProNum(resultSet.getInt("proNum"));
				menu.setProTotalPrice(resultSet.getString("proTotalPrice"));
				menus.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return menus;
	}
	/**
	 * 获取订单总数
	 */
	public int getTotalCount() {
		int totalCount=0;
		Object[] params ={};
		String sql ="SELECT COUNT(*) FROM `menu`";
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
	 * 修改订单
	 */
	public int updateMenu(Menu menu) {
		int flag = 0;
		String sql = "UPDATE `coffee`.`menu` SET `userName` = ? ,`proName` = ? , `proPrice` = ? , `userPhone` = ? , `userAddress` = ? , `menuStatu` = ? , `proNum` = ? , `proTotalPrice` = ? WHERE `menuNo` = ?";
		Object[] params = {menu.getUserName(),menu.getProName(),menu.getProPrice(),menu.getUserPhone(),menu.getUserAddress(),menu.getMenuStatu(),menu.getProNum(),menu.getProTotalPrice(),menu.getMenuNo()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	//前台分页显示信息
	public List<Menu> getQianMenus(int pageIndex, String userName ,int pageSize) {
		List<Menu> menus = new ArrayList<Menu>();
		int start =(pageIndex-1)*pageSize;
		Object[] params={userName,start,pageSize};
		String sql ="SELECT * FROM `menu` WHERE `userName`= ? ORDER BY menuNo DESC LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(resultSet.next()){
				Menu menu = new Menu();
				menu.setMenuNo(resultSet.getInt(1));
				menu.setProName(resultSet.getString("proName"));
				menu.setProPrice(resultSet.getString("proPrice"));
				menu.setUserName(resultSet.getString("userName"));
				menu.setUserPhone(resultSet.getString("userPhone"));
				menu.setUserAddress(resultSet.getString("userAddress"));
				menu.setMenuStatu(resultSet.getString("menuStatu"));
				menu.setProNum(resultSet.getInt("proNum"));
				menu.setProTotalPrice(resultSet.getString("proTotalPrice"));
				menus.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return menus;
	}
	/**
	 * 每个用户订单总数
	 */
	public int getTotalCount(String name) {
		int totalCount=0;
		Object[] params ={name};
		String sql ="SELECT COUNT(*) FROM `menu` where userName = ?";
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
