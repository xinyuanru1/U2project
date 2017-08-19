package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.UserDao;
import com.bdqn.entity.User;
/**
 * UserDao的实现类，对用户进行数据库的操作
 * @author xinyuanru1
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	/**
	 * 得到User总数
	 */
	public int getUser() {
		int totalCount= 0;
		Object [] params ={};
		String sql ="SELECT COUNT(*) FROM `user`";
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
	 * 按分页形式得到User集合
	 */
	public List<User> getUserList(int pageIndex, int pageSize) {
		List<User> users = new ArrayList<User>();
		int start = (pageIndex-1)*pageSize;
		Object[] param={start,pageSize};
		String sql ="SELECT * FROM `user` ORDER BY id desc LIMIT ?,?";
		ResultSet rs = super.executeQuery(sql, param);
		try {
			while(rs.next()){
				User use= new User();
				use.setId(rs.getInt(1));
				use.setIdCard(rs.getString(6));
				use.setPassword(rs.getString(4));
				use.setPhone(rs.getString(3));
				use.setRealName(rs.getString(5));
				use.setUserName(rs.getString(2));
				users.add(use);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return users;
	}
	
	/**
	 * 增加User
	 */
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "INSERT INTO `coffee`.`user` (`userName`, `phone`, `password`, `realName`, `idCard`) VALUES (?,?,?,?,?);";
		Object[] params = {user.getUserName(),user.getPhone(),user.getPassword(),user.getRealName(),user.getIdCard()};
		flag = super.executeUpdate(sql, params);
		return flag;
	}

	/**
	 * 根据id（主键）删除User
	 */
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "DELETE FROM `coffee`.`user` WHERE `id` = ?; ";
		Object[] params = {id};
		flag = super.executeUpdate(sql, params);
		return flag;
	}

	/**
	 * 得到所有User集合
	 */
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		if(getConnection()){
			String sql = "select * from user";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setIdCard(resultSet.getString("idCard"));
					user.setPassword(resultSet.getString("password"));
					user.setPhone(resultSet.getString("phone"));
					user.setRealName(resultSet.getString("realName"));
					user.setUserName(resultSet.getString("userName"));
					users.add(user);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return users;
	}

	/**
	 * 用户登陆，即返回数据库中密码和用户名相匹配的用户
	 */
	public User getUser(String userName, String password) {
		// TODO Auto-generated method stub
		User user = null;
		if(getConnection()){
			String sql = "select * from user where userName = ? and password = ?";
			Object[] params = {userName,password};
			try {
				
				resultSet = super.executeQuery(sql, params);
				while(resultSet.next()){
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setIdCard(resultSet.getString("idCard"));
					user.setPassword(resultSet.getString("password"));
					user.setPhone(resultSet.getString("phone"));
					user.setRealName(resultSet.getString("realName"));
					user.setUserName(resultSet.getString("userName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return user;
	}

	/**
	 * 修改User各项数据，id（主键）不可修改
	 */
	public int updateUser(int id, User user) {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "UPDATE `coffee`.`user` SET `userName` = ? , `phone` = ? , `password` = ? , `realName` = ? , `idCard` = ?,`statu` = ? WHERE `id` = ?; ";
		Object[] params = {user.getUserName(),user.getPhone(),user.getPassword(),user.getRealName(),user.getIdCard(),user.getStatu(),id};
		flag = super.executeUpdate(sql, params);
		return flag;
	}

	/**
	 * 根据id得到User实体
	 */
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		if(getConnection()){
			String sql = "select * from user where id = ?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					user = new User();
					user.setId(resultSet.getInt("id"));
					user.setIdCard(resultSet.getString("idCard"));
					user.setPassword(resultSet.getString("password"));
					user.setPhone(resultSet.getString("phone"));
					user.setRealName(resultSet.getString("realName"));
					user.setUserName(resultSet.getString("userName"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
