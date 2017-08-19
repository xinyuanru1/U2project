package com.bdqn.dao;

import java.sql.ResultSet;
/**
 * 基础类的接口
 * @author xinyuanru1
 *
 */
public interface BaseDao {

	/**
	 * 打开链接
	 */
	public boolean getConnection();
	/**
	 * 关闭链接
	 */
	public boolean closeConnection();
	/**
	 * 查询方法
	 */
	public ResultSet executeQuery(String sql,Object[] params);
	/**
	 * 增删改方法
	 */
	public int executeUpdate(String sql,Object[] params);
}
