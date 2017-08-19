package com.bdqn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.entity.News;
import com.bdqn.service.impl.NewsServiceImpl;

public class NewsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String flag = request.getParameter("flag");
		if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("add")){
			this.add(request, response);
		}else if(flag.equals("delete")){
			this.delete(request, response);
		}else if(flag.equals("getNewsForUpd")){
			this.getNewsForUpd(request, response);
		}else if(flag.equals("update")){
			this.update(request, response);
		}else if(flag.equals("detail")){
			this.detail(request, response);
		}else if(flag.equals("reGetAll")){
			this.reGetAll(request, response);
		}
	}
	//前台新闻显示
	public void reGetAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 5;
		int totalCount = new NewsServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<News> newss = new NewsServiceImpl().getNews(pageIndex, pageSize);
		request.getSession().setAttribute("pageIndex", pageIndex);
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("newss", newss);
		response.sendRedirect("XingChen/allNews.jsp");
	}
	/**
	 * 后台查看新闻
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		News news = new NewsServiceImpl().getByNo(Integer.parseInt(request.getParameter("newsNo")));
		request.getSession().setAttribute("news", news);
		response.sendRedirect("admin/detailNews.jsp");
	}
	/**
	 * 后台修改新闻
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		NewsServiceImpl ns = new NewsServiceImpl();
		int newsNo = Integer.parseInt(request.getParameter("newsNo"));
		String newsTitle = request.getParameter("newsTitle");
		String newsContent = request.getParameter("newsContent");
		//修改后的News
		News news = new News();
		news.setNewsNo(newsNo);
		news.setNewsTitle(newsTitle);
		news.setNewsContent(newsContent);
		//flag判断
		ns.update(news);
		this.getAll(request, response);
	}
	/**
	 * 后台修改新闻
	 */
	public void getNewsForUpd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		News news = new NewsServiceImpl().getByNo(Integer.parseInt(request.getParameter("newsNo")));
		request.getSession().setAttribute("news", news);
		response.sendRedirect("admin/updateNews.jsp");
	}
	/**
	 * 后台删除
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		new NewsServiceImpl().deletenews(Integer.parseInt(request.getParameter("newsNo")));
		this.getAll(request, response);
	}
	/**
	 * 后台添加新闻
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {	
		String newsTitle = request.getParameter("newsTitle");
		String newsContent = request.getParameter("newsContent");
		News news = new News();
		news.setNewsContent(newsContent);
		news.setNewsTitle(newsTitle);
		new NewsServiceImpl().addnews(news);
		this.getAll(request, response);
	}
	/**
	 * 后台分页
	 */
	public void getAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 2;
		int totalCount = new NewsServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int pageCount = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<News> newss = new NewsServiceImpl().getNews(pageIndex, pageSize);
		request.getSession().setAttribute("pageIndex", pageIndex);
		request.getSession().setAttribute("pageCount", pageCount);
		for (News news : newss) {
			String newsTitle = news.getNewsTitle();
			String newsContent = news.getNewsContent();
			if(newsTitle.length()>3){
				news.setNewsTitle(newsTitle.substring(0, 3)+"...");
			}
			if(newsContent.length()>5){
				news.setNewsContent(newsContent.substring(0, 5)+"...");
			}
		}
		request.getSession().setAttribute("newss", newss);
		response.sendRedirect("admin/listNews.jsp");
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
}
