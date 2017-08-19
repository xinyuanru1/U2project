package com.bdqn.service.impl;

import java.util.List;

import com.bdqn.dao.MenuDao;
import com.bdqn.dao.impl.MenuDaoImpl;
import com.bdqn.entity.Menu;
import com.bdqn.service.MenuService;

public class MenuServiceImpl implements MenuService{
	MenuDao menuDao;
	/**
	 * 构造方法
	 */
	public MenuServiceImpl(){
		menuDao = new MenuDaoImpl();
	}
	/**
	 * 添加订单
	 */
	public int addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}
	/**
	 * 删除订单
	 */
	public int deleteMenu(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(menuNo);
	}
	/**
	 * 查看订单
	 */
	public Menu getByNo(int menuNo) {
		// TODO Auto-generated method stub
		return menuDao.getByNo(menuNo);
	}
	/**
	 * 分页列表
	 */
	public List<Menu> getMenus(int pageInex, int pageSize) {
		// TODO Auto-generated method stub
		return menuDao.getMenus(pageInex, pageSize);
	}
	/**
	 * 订单总数
	 */
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return menuDao.getTotalCount();
	}
	/**
	 * 修改订单
	 */
	public int updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu);
	}
	/**
	 * 分页（根据用户名）
	 */
	public List<Menu> getQianMenus(int pageIndex, String userName, int pageSize) {
		// TODO Auto-generated method stub
		return menuDao.getQianMenus(pageIndex, userName, pageSize);
	}
	/**
	 * 订单总数（根据用户名）
	 */
	public int getTotalCount(String name) {
		// TODO Auto-generated method stub
		return menuDao.getTotalCount(name);
	}
}
