package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Coffee;
/**
 * CoffeeDao的接口，对咖啡进行数据库的操作
 * @author xinyuanru1
 *
 */
public interface CoffeeDao {

	/**
	 * 增加Coffee
	 */
	public int addCoffee(Coffee coffee);
	/**
	 * 根据coffeeNo（主键）删除Coffee
	 */
	public int deleteCoffee(int CoffeeNo);
	/**
	 * 修改Coffee各项数据，CoffeeNo（主键）不可修改
	 */
	public int updateCoffee(Coffee coffee);
	/**
	 * 得到所有Coffee集合
	 */
	public List<Coffee> getAll();
	/**
	 * 根据coffeeNo和coffeeName得到Coffee实体 查一条
	 */
	public Coffee getCoffeeByNo(int coffeeNo);
	public Coffee getCoffeeByNo(String coffeeName);
	/**
	 * 得到Coffee总数
	 */
	public int getTotalCount();
	/**
	 * 按分页形式得到Coffee集合
	 */
	public List<Coffee> getNews(int pageIndex,int pageSize);
	/**
	 * 按类别得到Coffee集合
	 */
	public List<Coffee> getByType(int pageIndex,int pageSize,String type);
}
