package com.bdqn.dao;

import java.util.List;

import com.bdqn.entity.GouWuChe;
import com.bdqn.entity.Menu;

public interface GouWuCheDao {
	/**
	 * 添加商品到购物车
	 */
	public int addMenu(GouWuChe gouWuChe);
	/**
	 * 删除购物车列表
	 */
	public int deleteMenu(int menuNo);
	/**
	 * 修改列表
	 */
	public int updateMenu(GouWuChe gouWuChe);
	/**
	 * 查看单个列表
	 */
	public GouWuChe getByNo(int menuNo);
	
	//计算总数
	public int getTotalCount(String userName);
	//计算当前列表
	public List<GouWuChe> getMenus(String userName,int pageInex,int pageSize);
}
