package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.User;
/**
 * 顾客信息
 */
public interface UserDao {
	/**
	 * 添加顾客
	 */
	public int addUser(User user);
	/**
	 * 删除顾客
	 */
	public int deleteUser(int id);
	/**
	 * 修改顾客
	 */
	public int updateUser(int id,User user);
	/**
	 * 顾客信息列表
	 */
	public ArrayList<User> getAll();
	/**
	 * 查看顾客信息（登录）
	 */
	public User getUser(String userName,String password);
	/**
	 * 查看顾客信息
	 */
	public User getUserById(int id);
	
	public int getUser();
	/**
	 * 顾客信息分页
	 */
	public List<User> getUserList(int pageIndex,int pageSize);
}
