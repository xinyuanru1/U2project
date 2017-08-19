package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.GouWuCheDao;
import com.bdqn.dao.MenuDao;
import com.bdqn.entity.GouWuChe;
import com.bdqn.entity.Menu;

public class GouWuCheDaoImpl extends BaseDaoImpl implements GouWuCheDao {
	/**
	 * 添加商品到购物车
	 */
	public int addMenu(GouWuChe gouWuChe) {
		int flag = 0;
		String sql = "INSERT INTO `coffee`.`shopping` (`userName`, `proName`, `proPrice`) VALUES (?,?,?);  ";
		Object[] params = {gouWuChe.getUserName(),gouWuChe.getProName(),gouWuChe.getProPrice()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 删除购物车列表
	 */
	public int deleteMenu(int menuNo) {
		int flag = 0;
		String sql = "DELETE FROM coffee.`shopping` WHERE `menuNo` = ?;" ;
		Object[] params = {menuNo};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	/**
	 * 获取购物车商品列表
	 */
	public GouWuChe getByNo(int menuNo) {
		GouWuChe menu = null;
		String sql = "SELECT * FROM coffee.`shopping` WHERE `menuNo` = ?";
		Object[] params = {menuNo};
		resultSet = super.executeQuery(sql, params);
		try {
			while(resultSet.next()){
				menu = new GouWuChe();
				menu.setMenuNo(menuNo);
				menu.setProName(resultSet.getString("proName"));
				menu.setProPrice(resultSet.getString("proPrice"));
				menu.setUserName(resultSet.getString("userName"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	/**
	 * 列表分页
	 */
	public List<GouWuChe> getMenus(String userName,int pageIndex, int pageSize) {
		List<GouWuChe> menus = new ArrayList<GouWuChe>();
		int start =(pageIndex-1)*pageSize;
		Object[] params={userName,start,pageSize};
		String sql ="SELECT * FROM `shopping` where userName=? ORDER BY menuNo desc LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, params);
		try {
			while(resultSet.next()){
				GouWuChe menu = new GouWuChe();
				menu.setMenuNo(resultSet.getInt(1));
				menu.setProName(resultSet.getString("proName"));
				menu.setProPrice(resultSet.getString("proPrice"));
				menu.setUserName(resultSet.getString("userName"));
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
	 * 获取信息总数
	 */
	public int getTotalCount(String userName) {
		int totalCount=0;
		Object[] params ={userName};
		String sql ="SELECT COUNT(*) FROM `shopping` where userName=?";
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
	 * 修改购物车列表
	 */
	public int updateMenu(GouWuChe gouWuChe) {
		int flag = 0;
		String sql = "UPDATE `coffee`.`shopping` SET `userName` = ? , `proName` = ? , `proPrice` = ?  WHERE `menuNo` = ?;";
		Object[] params = {gouWuChe.getUserName(),gouWuChe.getProName(),gouWuChe.getProPrice(),gouWuChe.getMenuNo()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}
	
}
