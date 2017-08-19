package com.bdqn.service;

import java.util.List;

import com.bdqn.entity.GouWuChe;
import com.bdqn.entity.Menu;
/**
 * 购物车
 */
public interface GouWuCheService {
	/**
	 * 添加商品到购物车
	 */
	public int addMenu(GouWuChe gouWuChe);
	/**
	 * 删除商品
	 */
	public int deleteMenu(int menuNo);
	/**
	 * 修改购物车商品
	 */
	public int updateMenu(GouWuChe gouWuChe);
	/**
	 * 产看商品
	 */
	public GouWuChe getByNo(int menuNo);
	
	//计算总数
	public int getTotalCount(String userName);
	//计算当前列表
	public List<GouWuChe> getMenus(String userName,int pageInex,int pageSize);
}
