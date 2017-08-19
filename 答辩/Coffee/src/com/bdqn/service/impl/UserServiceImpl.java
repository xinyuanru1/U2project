package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.entity.User;
import com.bdqn.service.UserService;

public class UserServiceImpl implements UserService{

	UserDaoImpl userDaoImpl = null;
	/**
	 * 构造方法
	 */
	public UserServiceImpl(){
		userDaoImpl = new UserDaoImpl();
	}
	/**
	 * 添加用户
	 */
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDaoImpl.addUser(user);
	}
	/**
	 * 删除用户
	 */
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDaoImpl.deleteUser(id);
	}
	/**
	 * 用户列表
	 */
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return userDaoImpl.getAll();
	}
	/**
	 * 查看用户信息（登录）
	 */
	public User getUser(String userName, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUser(userName, password);
	}
	/**
	 * 修改用户
	 */
	public int updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return userDaoImpl.updateUser(id, user);
	}
	/**
	 * 查看用户
	 */
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserById(id);
	}
	/**
	 * 用户总数
	 */
	public int getUser() {
		// TODO Auto-generated method stub
		return userDaoImpl.getUser();
	}
	/**
	 *分页 列表
	 */
	public List<User> getUserList(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserList(pageIndex, pageSize);
	}

}
