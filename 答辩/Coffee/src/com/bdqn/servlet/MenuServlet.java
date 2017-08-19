package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.entity.Menu;
import com.bdqn.entity.User;
import com.bdqn.service.impl.CoffeeServiceImpl;
import com.bdqn.service.impl.MenuServiceImpl;

public class MenuServlet extends HttpServlet {

	
	public MenuServlet() {
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
		String flag = request.getParameter("flag");
		if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("add")){
			this.add(request, response);
		}else if(flag.equals("delete")){
			this.delete(request, response);
		}else if(flag.equals("getMenuForUpd")){
			this.getMenuForUpd(request, response);
		}else if(flag.equals("update")){
			this.update(request, response);
		}else if(flag.equals("getDetail")){
			this.getDetail(request, response);
		}else if(flag.equals("qianAdd")){
			this.qianAdd(request, response);
		}else if(flag.equals("list")){
			this.qianList(request, response);
		}else if(flag.equals("deletel")){
			this.qianDelete(request, response);
		}else if(flag.equals("detail")){
			this.qianDetail(request, response);
		}else if(flag.equals("pay")){
			this.pay(request, response);
		}
	}
	//支付状态
	public void pay(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Menu menu = new MenuServiceImpl().getByNo(Integer.parseInt(request.getParameter("menuNo")));
		menu.setMenuStatu("已支付");
		new MenuServiceImpl().updateMenu(menu);
		response.sendRedirect("XingChen/success_order_payment.jsp");
	}
	//首页订单查看
	public void qianDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Menu menu = new MenuServiceImpl().getByNo(Integer.parseInt(request.getParameter("menuNo")));
		request.getSession().setAttribute("menu", menu);
		response.sendRedirect("admin/detailMenu.jsp");
	}
	//首页订单删除
	public void qianDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		new MenuServiceImpl().deleteMenu(Integer.parseInt(request.getParameter("menuNo")));
		this.qianList(request, response);
	}
	/**
	 * 前台分页显示
	 */
	public void qianList(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageIndexStr = request.getParameter("pageIndex");
		Object u = request.getSession().getAttribute("user");
		if(u == null){
			request.getSession().setAttribute("msg", "请先登录");
			response.sendRedirect("login/login.jsp");
		}else{
			User user = (User)u ;
			String userName = user.getUserName();
			if(pageIndexStr==null){
				pageIndexStr = "1";
			}
			int pageIndex = Integer.parseInt(pageIndexStr);
			int pageSize = 6;
			int totalCount = new MenuServiceImpl().getTotalCount(userName);
			if(totalCount==0){
				totalCount=1;
			}
			int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(1+totalCount/pageSize);
			List<Menu> menus = new MenuServiceImpl().getQianMenus(pageIndex, userName, pageSize);
			HttpSession session = request.getSession();
			session.setAttribute("pageIndex", pageIndex);
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("menus", menus);
			response.sendRedirect("XingChen/payment.jsp");
		}
		
	}
	/**
	 * 前台购买商品
	 */
	public void qianAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		int proNum=Integer.parseInt(request.getParameter("proNum"));
		String proTotalPrice=request.getParameter("proTotalPrice");
		String menuStatu = "未支付";
		Menu menu = new Menu();
		menu.setProName(proName);
		menu.setProPrice(proPrice);
		menu.setUserName(userName);
		menu.setUserPhone(userPhone);
		menu.setUserAddress(userAddress);
		menu.setMenuStatu(menuStatu);
		menu.setProNum(proNum);
		menu.setProTotalPrice(proTotalPrice);
		new MenuServiceImpl().addMenu(menu);
		response.sendRedirect("XingChen/success_payment.jsp");
	}
	/**
	 * 后台查看
	 */
	public void getDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Menu menu = new MenuServiceImpl().getByNo(Integer.parseInt(request.getParameter("menuNo")));
		request.getSession().setAttribute("menu", menu);
		response.sendRedirect("admin/detailMenu.jsp");
	}
	/**
	 * 后台修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		String menuStatu = request.getParameter("menuStatu");
		int menuNo = Integer.parseInt(request.getParameter("menuNo"));
		Menu menu = new Menu();
		menu.setMenuNo(menuNo);
		menu.setProName(proName);
		menu.setProPrice(proPrice);
		menu.setUserName(userName);
		menu.setUserPhone(userPhone);
		menu.setUserAddress(userAddress);
		menu.setMenuStatu(menuStatu);
		new MenuServiceImpl().updateMenu(menu);
		this.getAll(request, response);
	}
	/**
	 * 后台修改订单
	 */
	public void getMenuForUpd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Menu menu = new MenuServiceImpl().getByNo(Integer.parseInt(request.getParameter("menuNo")));
		request.getSession().setAttribute("menu", menu);
		response.sendRedirect("admin/updateMenu.jsp");
	}
	/**
	 * 后台删除
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		new MenuServiceImpl().deleteMenu(Integer.parseInt(request.getParameter("menuNo")));
		this.getAll(request, response);
	}
	/**
	 * 后台添加
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String proName = request.getParameter("proName");
		String proPrice = request.getParameter("proPrice");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		int proNum=Integer.parseInt(request.getParameter("proNum"));
		String proTotalPrice = request.getParameter("proTotalPrice");
		String menuStatu = "未支付";
		Menu menu = new Menu();
		menu.setProName(proName);
		menu.setProPrice(proPrice);
		menu.setUserName(userName);
		menu.setUserPhone(userPhone);
		menu.setUserAddress(userAddress);
		menu.setMenuStatu(menuStatu);
		menu.setProTotalPrice(proTotalPrice);
		menu.setProNum(proNum);
		new MenuServiceImpl().addMenu(menu);
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
		int totalCount = new MenuServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<Menu> menus = new MenuServiceImpl().getMenus(pageIndex, pageSize);
		HttpSession session = request.getSession();
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("menus", menus);
		response.sendRedirect("admin/listMenu.jsp");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
