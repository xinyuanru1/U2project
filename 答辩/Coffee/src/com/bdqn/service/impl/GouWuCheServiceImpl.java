package com.bdqn.service.impl;

import java.util.List;

import com.bdqn.dao.GouWuCheDao;
import com.bdqn.dao.MenuDao;
import com.bdqn.dao.impl.GouWuCheDaoImpl;
import com.bdqn.dao.impl.MenuDaoImpl;
import com.bdqn.entity.GouWuChe;
import com.bdqn.entity.Menu;
import com.bdqn.service.GouWuCheService;
import com.bdqn.service.MenuService;

public class GouWuCheServiceImpl implements GouWuCheService{
	GouWuCheDao menuDao;
	/**
	 * 构造方法
	 */
	public GouWuCheServiceImpl(){
		menuDao = new GouWuCheDaoImpl();
	}
	/**
	 * 添加商品到购物车
	 */
	public int addMenu(GouWuChe gouWuChe) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(gouWuChe);
	}
	/**
	 * 删除商品
	 */
	public int deleteMenu(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(menuNo);
	}
	/**
	 * 查看商品
	 */
	public GouWuChe getByNo(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.getByNo(menuNo);
	}
	/**
	 * 分页列表
	 */
	public List<GouWuChe> getMenus(String userName,int pageInex, int pageSize) {
		// TODO Auto-generated method stub
		return menuDao.getMenus(userName,pageInex, pageSize);
	}
	/**
	 * 信息总数
	 */
	public int getTotalCount(String userName) {
		// TODO Auto-generated method stub
		return menuDao.getTotalCount(userName);
	}
	/**
	 * 修改
	 */
	public int updateMenu(GouWuChe gouWuChe) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(gouWuChe);
	}
	
	
	
}
