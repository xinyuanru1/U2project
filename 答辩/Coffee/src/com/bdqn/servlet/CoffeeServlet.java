package com.bdqn.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bdqn.entity.Coffee;
import com.bdqn.entity.User;
import com.bdqn.service.impl.CoffeeServiceImpl;

public class CoffeeServlet extends HttpServlet {

	
	public CoffeeServlet() {
		super();
	}

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
//		this.isNotAdmin(request, response);
		String flag =request.getParameter("flag");
		if(flag.equals("add")){
			this.addCoffee(request, response);
		}else if(flag.equals("delete")){
			this.deleteCoffee(request, response);
		}else if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("updateCoffee")){
			this.updateCoffee(request, response);
		}else if(flag.equals("getDetail")){
			this.getDetail(request, response);
		}else if(flag.equals("getAllForUpdate")){
			this.getAllForUpdate(request, response);
		}else if(flag.equals("getAllCoffeeQian")){
			this.getAllCoffeeQian(request, response);
		}else if(flag.equals("QgetDetail")){
			this.QgetDetail(request, response);
		}else if(flag.equals("detail")){
			this.proName(request, response);
		}else if(flag.equals("getByType")){
			this.getByType(request, response);
		}else if(flag.equals("listALL")){
			this.getAllPic(request, response);
		}	
	}
	/**
	 * 后台分页列表
	 */
	public void getByType(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageIndexStr = request.getParameter("pageIndex");
		String type = request.getParameter("type");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 200;
		int totalCount = new CoffeeServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		if(totalPage==0){totalPage=1;}
		List<Coffee> coffees = new CoffeeServiceImpl().getByType(pageIndex, pageSize, type);
		request.getSession().setAttribute("pageIndex", pageIndex);
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("coffees", coffees);
		response.sendRedirect("XingChen/allCoffee.jsp");
	}
	//前台查看订单
	public void proName(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(request.getParameter("proName"));
		request.getSession().setAttribute("coffee", coffee);
		response.sendRedirect("XingChen/goods1.jsp");
	}
	/**
	 * 前台查看产品
	 */
	public void QgetDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(Integer.parseInt(request.getParameter("coffeeNo")));
		request.getSession().setAttribute("coffee", coffee);
		response.sendRedirect("XingChen/goods1.jsp");
	}
	/**
	 * 前台获取所有产品列表分页
	 */
	public void getAllCoffeeQian(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<Coffee> coffees = new CoffeeServiceImpl().getAll();
		request.getSession().setAttribute("coffees", coffees);
		response.sendRedirect("XingChen/allCoffee.jsp");
	}
	/**
	 * 后台修改产品类别
	 */
	public void getAllForUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(Integer.parseInt(request.getParameter("coffeeNo")));
		request.getSession().setAttribute("coffee", coffee);
		String[] types = {"早咖啡","午咖啡","晚咖啡","午夜咖啡"};
		request.getSession().setAttribute("types", types);
		response.sendRedirect("admin/updateCoffee.jsp");
	}
	/**
	 * 后台查看产品信息
	 */
	public void getDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int coffeeNo = Integer.parseInt(request.getParameter("coffeeNo"));
		Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(coffeeNo);
		request.getSession().setAttribute("coffee", coffee);
		response.sendRedirect("admin/detailCoffee.jsp");
	}
	/**
	 * 后台上传图片
	 */
	public void updateCoffee(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		CoffeeServiceImpl cs = new CoffeeServiceImpl();
		boolean bRet = false;
		boolean bUpload = false;
		String uploadFileName = "";
		String fileName = "";
		Coffee coffee = new Coffee();
		ServletFileUpload servletFileUpload = new ServletFileUpload();
		servletFileUpload.setHeaderEncoding("UTF-8");
		boolean isMultipart = servletFileUpload.isMultipartContent(request);
		String uploadFilePath = request.getSession().getServletContext().getRealPath("upload");
		File saveDir = new File(uploadFilePath);
		if (!saveDir.exists()) {
			saveDir.mkdirs();
		}
		if (isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					fileName = item.getFieldName();
					if(fileName.equals("coffeeName")){
						coffee.setCoffeeName(item.getString("UTF-8"));
					}else if(fileName.equals("coffeePrice")){
						coffee.setCoffeePrice(item.getString("UTF-8"));
					}else if(fileName.equals("coffeeType")){
						coffee.setCoffeeType(item.getString("UTF-8"));
					}else if(fileName.equals("coffeeNo")){
						coffee.setCoffeeNo(Integer.parseInt(item.getString("UTF-8")));
					}
				}else{
					fileName = item.getName();
					if (fileName != null && !fileName.equals("")){
						File fullFile = new File(fileName);
						File saveFile = new File(uploadFilePath,fullFile.getName());
						try {
							item.write(saveFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
						uploadFileName = fullFile.getName();
						coffee.setPicPath(uploadFileName);
						bUpload = true;
					}
				}
			}
		}
	cs.updateCoffee(coffee);
	this.getAll(request, response);
	
}
	/**
	 * 后台所有商品分页
	 */
	public void getAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 2;
		int totalCount = new CoffeeServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		
		List<Coffee> coffees = new CoffeeServiceImpl().getNews(pageIndex, pageSize);
		request.getSession().setAttribute("pageIndex", pageIndex);
		request.getSession().setAttribute("totalPage", totalPage);
		request.getSession().setAttribute("coffees", coffees);
		response.sendRedirect("admin/listCoffee.jsp");
	}
	
	/**
	 * 前台获取商品图片
	 */
	public void addCoffee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			CoffeeServiceImpl cs = new CoffeeServiceImpl();
			boolean bRet = false;
			boolean bUpload = false;
			String uploadFileName = "";
			String fileName = "";
			Coffee coffee = new Coffee();
			ServletFileUpload servletFileUpload = new ServletFileUpload();
			servletFileUpload.setHeaderEncoding("UTF-8");
			boolean isMultipart = servletFileUpload.isMultipartContent(request);
			String uploadFilePath = request.getSession().getServletContext().getRealPath("upload");
			File saveDir = new File(uploadFilePath);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = null;
				try {
					items = upload.parseRequest(request);
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					if (item.isFormField()) {
						fileName = item.getFieldName();
						if(fileName.equals("coffeeName")){
							coffee.setCoffeeName(item.getString("UTF-8"));
						}else if(fileName.equals("coffeePrice")){
							coffee.setCoffeePrice(item.getString("UTF-8"));
						}else if(fileName.equals("coffeeType")){
							coffee.setCoffeeType(item.getString("UTF-8"));
						}
					}else{
						fileName = item.getName();
						if (fileName != null && !fileName.equals("")){
							File fullFile = new File(fileName);
							File saveFile = new File(uploadFilePath,fullFile.getName());
							try {
								item.write(saveFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
							uploadFileName = fullFile.getName();
							coffee.setPicPath(uploadFileName);
							bUpload = true;
						}
					}
				}
			}
			cs.addCoffee(coffee);
			this.getAll(request, response);
	}
	/**
	 * 后台删除商品
	 */
	public void deleteCoffee(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		CoffeeServiceImpl cs = new CoffeeServiceImpl();
		int coffeeNo = Integer.parseInt(request.getParameter("coffeeNo"));
		cs.deleteCoffee(coffeeNo);
		this.getAll(request, response);
	}
	/**
	 * 登录判断
	 */
	public void isNotAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User user = (User)(request.getSession().getAttribute("user"));
		if(user==null||!user.equals("admin")){
			request.getSession().setAttribute("msg", "请先登录管理员账号！");
			response.sendRedirect("login/login.jsp");
		}
	}
	/**
	 * 前台首页图片混动
	 */
	public void getAllPic(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		List<Coffee> coffees = new CoffeeServiceImpl().getAll();
		request.getSession().setAttribute("coffees", coffees);
		response.sendRedirect("XingChen/index.jsp");
	}
		
	public void init() throws ServletException {
		// Put your code here
	}
}
