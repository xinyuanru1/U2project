package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bdqn.dao.BaseDao;
import com.bdqn.util.ConfigManager;
/**
 * 基础类的实现类
 * @author xinyuanru1
 *
 */
public class BaseDaoImpl implements BaseDao{

	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	/**
	 * 关闭链接
	 */
	public boolean closeConnection() {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag = false;
				e.printStackTrace();
			}
		}
		if(preparedStatement != null){
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag = false;
				e.printStackTrace();
			}
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag = false;
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				flag = false;
				e.printStackTrace();
			}
		}
		return flag;
	}
/**
 * 打开链接
 */
	public boolean getConnection() {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			Class.forName(ConfigManager.getInstance().getString("jdbc.driver.class"));
			connection = DriverManager.getConnection(ConfigManager.getInstance().getString("jdbc.connection.url"),ConfigManager.getInstance().getString("jdbc.connection.username"),ConfigManager.getInstance().getString("jdbc.connection.password"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} 
		return flag;
	}
	/**
	 * 查询方法
	 */
	public ResultSet executeQuery(String sql,Object[] params){
		try {
			if (this.getConnection()) {
				preparedStatement=connection.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject((i+1), params[i]);
				}
				resultSet=preparedStatement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	/**
	 * 增删改方法
	 */
	public int executeUpdate(String sql,Object[] params){
		int result=0;
		try {
			if (this.getConnection()) {
				preparedStatement=connection.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					preparedStatement.setObject((i+1), params[i]);
				}
				result=preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeConnection();
		}
		return result;
	}
}
