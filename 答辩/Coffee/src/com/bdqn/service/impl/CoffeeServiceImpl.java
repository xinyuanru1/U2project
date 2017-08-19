package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bdqn.dao.impl.CoffeeDaoImpl;
import com.bdqn.entity.Coffee;
import com.bdqn.service.CoffeeService;

public class CoffeeServiceImpl implements CoffeeService{

	CoffeeDaoImpl coffeeDaoImpl;
	/**
	 * 构造方法
	 */
	public CoffeeServiceImpl(){
		coffeeDaoImpl = new CoffeeDaoImpl();
	}
	/**
	 * 产品列表
	 */
	public List<Coffee> getAll() {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.getAll();
	}
	/**
	 * 添加产品
	 */
	public int addCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.addCoffee(coffee);
	}
	/**
	 * 删除产品
	 */
	public int deleteCoffee(int coffeeNo) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.deleteCoffee(coffeeNo);
	}
	/**
	 * 修改产品
	 */
	public int updateCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.updateCoffee(coffee);
	}
	/**
	 * 查看产品
	 */
	public Coffee getCoffeeByNo(int coffeeNo) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.getCoffeeByNo(coffeeNo);
	}
	/**
	 * 列表分页
	 */
	public List<Coffee> getNews(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.getNews(pageIndex, pageSize);
	}
	/**
	 * 列表总数
	 */
	@Test
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.getTotalCount();
	}
	/**
	 * 查看产品（根据产品名称）
	 */
	public Coffee getCoffeeByNo(String coffeeName) {
		// TODO Auto-generated method stub
		Coffee coffee=coffeeDaoImpl.getCoffeeByNo(coffeeName);
		return coffee;
	}
	/**
	 * 列表分页（按产品类型）
	 */
	public List<Coffee> getByType(int pageIndex, int pageSize, String type) {
		// TODO Auto-generated method stub
		return coffeeDaoImpl.getByType(pageIndex, pageSize, type);
	}

}
