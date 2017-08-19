package com.bdqn.service;

import java.util.ArrayList;
import java.util.List;

import com.bdqn.entity.Menu;
import com.bdqn.entity.News;

public interface NewsService {
	/**
	 * 增加新闻
	 */
	public int addnews(News news);
	/**
	 * 删除新闻
	 */
	public int deletenews(int newsNo);
	/**
	 * 修改新闻
	 */
	public int update(News news);
	/**
	 * 新闻列表
	 */
	public List<News> getAll();
	/**
	 * 查看新闻
	 */
	public News getByNo(int newsNo);
	//计算总数
	public int getTotalCount();
	
   //计算当前页列表
	public List<News> getNews(int pageIndex, int pageSize);
	
}
