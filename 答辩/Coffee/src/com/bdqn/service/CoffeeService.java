package com.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bdqn.entity.Coffee;
/**
 * 咖啡类
 */
public interface CoffeeService {
	/**
	 * 添加产品
	 */
	public int addCoffee(Coffee coffee);
	/**
	 * 删除商品
	 */
	public int deleteCoffee(int CoffeeNo);
	/**
	 * 修改商品
	 */
	public int updateCoffee(Coffee coffee);
	/**
	 * 商品列表
	 */
	public List<Coffee> getAll();
	/**
	 * 查看商品（根据商品名查看）
	 */
	public Coffee getCoffeeByNo(String coffeeName);
	/**
	 * 查看商品（根据编号查看）
	 */
	public Coffee getCoffeeByNo(int coffeeNo);
	//计算总数
	public int getTotalCount();
	//计算当前页列表
	public List<Coffee> getNews(int pageIndex,int pageSize);
	/**
	 * 按类别得到Coffee集合
	 */
	public List<Coffee> getByType(int pageIndex,int pageSize,String type);
}
