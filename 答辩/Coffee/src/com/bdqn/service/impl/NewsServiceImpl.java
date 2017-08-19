package com.bdqn.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.entity.Menu;
import com.bdqn.entity.News;
import com.bdqn.service.NewsService;

public class NewsServiceImpl implements NewsService{

	NewsDaoImpl newsDaoImpl;
	/**
	 * 构造方法
	 */
	public NewsServiceImpl(){
		newsDaoImpl = new NewsDaoImpl();
	}
	/**
	 *添加新闻 
	 */
	public int addnews(News news) {
		// TODO Auto-generated method stub
		return newsDaoImpl.addNews(news);
	}
	/**
	 * 删除新闻
	 */
	public int deletenews(int newsNo) {
		// TODO Auto-generated method stub
		return newsDaoImpl.delNews(newsNo);
	}
	/**
	 * 新闻列表
	 */
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return newsDaoImpl.getAll();
	}
	/**
	 * 查看新闻
	 */
	public News getByNo(int newsNo) {
		// TODO Auto-generated method stub
		return newsDaoImpl.searchByNewsNo(newsNo);
	}
	/**
	 * 修改新闻
	 */
	public int update(News news) {
		// TODO Auto-generated method stub
		return newsDaoImpl.updateStudent(news);
	}
	/**
	 * 新闻分页
	 */
	public List<News> getNews(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return newsDaoImpl.getNews(pageIndex, pageSize);
	}
	/**
	 * 新闻总数
	 */
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return newsDaoImpl.getTotalCount();
	}

}
