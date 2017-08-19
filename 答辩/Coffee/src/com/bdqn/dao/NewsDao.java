package com.bdqn.dao;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.News;

public interface NewsDao {
	/**
	 * 获取新闻列表
	 */
	public List<News> getAll();
	/**
	 * 添加新闻
	 */
	public int addNews(News news);
	/**
	 * 查看新闻
	 */
	public News searchByNewsNo(int newsNo);
	/**
	 * 删除新闻
	 */
	public int delNews(int newsNo);
	/**
	 * 修改新闻
	 */
	public int updateStudent(News news);
	//计算总数
	public int getTotalCount();
	
//计算当前页列表
	public List<News> getNews(int pageIndex, int pageSize);
}
