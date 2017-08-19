package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.Menu;
/**
 * 订单接口
 */
public interface MenuDao {
	/**
	 * 购买商品
	 */
	public int addMenu(Menu menu);
	/**
	 * 删除订单
	 */
	public int deleteMenu(int menuNo);
	/**
	 * 修改订单
	 */
	public int updateMenu(Menu menu);
	/**
	 * 查看订单
	 */
	public Menu getByNo(int menuNo);
	
	//计算总数
	public int getTotalCount();
	//计算总数
	public int getTotalCount(String name);
	//计算当前列表(后台)
	public List<Menu> getMenus(int pageInex,int pageSize);
	//计算当前列表（前台）
	public List<Menu> getQianMenus(int pageIndex,String userName ,int pageSize);
}
