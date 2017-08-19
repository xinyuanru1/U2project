package com.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.User;

public interface UserService {
	/**
	 * 添加用户
	 */
	public int addUser(User user);
	/**
	 * 删除用户
	 */
	public int deleteUser(int id);
	/**
	 * 修改用户
	 */
	public int updateUser(int id,User user);
	/**
	 * 用户列表
	 */
	public ArrayList<User> getAll();
	/**
	 * 查看用户（根据用户名和密码）
	 */
	public User getUser(String userName,String password);
	/**
	 * 查看用户（根据用户编号）
	 */
	public User getUserById(int id);
	//计算总数
	public int getUser();
	//计算当前列表
	public List<User> getUserList(int pageIndex,int pageSize);
}
