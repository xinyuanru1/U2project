package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.entity.Order;
import com.bdqn.entity.User;
import com.bdqn.service.impl.CoffeeServiceImpl;
import com.bdqn.service.impl.OrderServiceImpl;

public class OrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
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
		if(flag.equals("add")){
			this.addOrder(request, response);
		}else if(flag.equals("delete")){
			this.deleteOrder(request, response);
		}else if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("update")){
			this.update(request, response);
		}else if(flag.equals("getOrderForUpd")){
			this.getOrderForUpd(request, response);
		}else if(flag.equals("getDetail")){
			this.getDetail(request, response);
		}else if(flag.equals("qAdd")){
			this.qAdd(request, response);
		}else if(flag.equals("getTheOrder")){
			this.getTheOrder(request, response);
		}else if(flag.equals("qList")){
			this.qList(request, response);
		}else if(flag.equals("detail")){
			this.qDetail(request, response);
		}else if(flag.equals("update1")){
			this.qUpdate(request, response);
		}else if(flag.equals("qdelete")){
			this.qDelete(request, response);
		}
	}
	
	//前台删除信息
	public void qDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.deleteOrderDao(orderNo);
		response.sendRedirect("XingChen/delete_order.jsp");
	}
	//前台修改信息
	public void qUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Order order = new Order();
		order.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
		order.setOrderName(request.getParameter("orderName"));
		order.setOrderNum(Integer.parseInt(request.getParameter("orderNum")));
		order.setOrderPhone(request.getParameter("orderPhone"));
		order.setOrderTime(request.getParameter("orderTime"));
		new OrderServiceImpl().updateOrder(order);
		response.sendRedirect("XingChen/success_update_order.jsp");
	}
	//前台修改订单
	public void qDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Order order = new OrderServiceImpl().getByNo(Integer.parseInt(request.getParameter("orderNo")));
		request.getSession().setAttribute("order", order);
		response.sendRedirect("XingChen/updateOrder.jsp");
	}
	/**
	 * 后台分页
	 */
	public void getTheOrder(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String name = request.getParameter("name");
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 2;
		int totalCount = new OrderServiceImpl().getTheTotalCount(name);
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<Order> orders = new OrderServiceImpl().getTheOrdees(name, pageIndex, pageSize);
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("orders", orders);
		response.sendRedirect("admin/listTheOrder.jsp");
	}
	//查看预定列表
	public void qList(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String realName=user.getRealName();
		String pageIndexStr = request.getParameter("pageIndex");
		if(pageIndexStr==null){
			pageIndexStr = "1";
		}
		int pageIndex = Integer.parseInt(pageIndexStr);
		int pageSize = 2;
		int totalCount = new OrderServiceImpl().getTheTotalCount(realName);
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		if(totalPage==0){totalPage=1;}
		List<Order> orders = new OrderServiceImpl().getTheOrdees(realName, pageIndex, pageSize);
		HttpSession session = request.getSession();
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("orders", orders);
		response.sendRedirect("XingChen/listOrder.jsp");
		
	}
	/**
	 * 前台预订成功
	 */
	public void qAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String orderPhone = request.getParameter("orderPhone");
		String orderName = request.getParameter("orderName");
		String orderTime = request.getParameter("orderTime");
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		Order order = new Order();
		order.setOrderName(orderName);
		order.setOrderNum(orderNum);
		order.setOrderPhone(orderPhone);
		order.setOrderTime(orderTime);
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.addOrderDao(order);
		response.sendRedirect("XingChen/success_order.jsp");
	}
	/**
	 * 后台查看
	 */
	public void getDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Order order = new OrderServiceImpl().getByNo(Integer.parseInt(request.getParameter("orderNo")));
		request.getSession().setAttribute("order", order);
		response.sendRedirect("admin/detailOrder.jsp");
	}
	/**
	 * 后台修改
	 */
	public void getOrderForUpd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Order order =  new OrderServiceImpl().getByNo(Integer.parseInt(request.getParameter("orderNo")));
		request.getSession().setAttribute("order", order);
		response.sendRedirect("admin/updateOrder.jsp");
	}
	/**
	 * 后台修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Order order = new Order();
		order.setOrderNo(Integer.parseInt(request.getParameter("orderNo")));
		order.setOrderName(request.getParameter("orderName"));
		order.setOrderNum(Integer.parseInt(request.getParameter("orderNum")));
		order.setOrderPhone(request.getParameter("orderPhone"));
		order.setOrderTime(request.getParameter("orderTime"));
		new OrderServiceImpl().updateOrder(order);
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
		int totalCount = new OrderServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int totalPage = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<Order> orders = new OrderServiceImpl().getOrdees(pageIndex, pageSize);
		HttpSession session = request.getSession();
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("orders", orders);
		response.sendRedirect("admin/listOrder.jsp");
	}
	/**
	 * 前台删除
	 */
	public void deleteOrder(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.deleteOrderDao(orderNo);
		this.getAll(request, response);
	}
	/**
	 * 前台添加
	 */
	public void addOrder(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String orderPhone = request.getParameter("orderPhone");
		String orderName = request.getParameter("orderName");
		String orderTime = request.getParameter("orderTime");
		int orderNum = Integer.parseInt(request.getParameter("orderNum"));
		Order order = new Order();
		order.setOrderName(orderName);
		order.setOrderNum(orderNum);
		order.setOrderPhone(orderPhone);
		order.setOrderTime(orderTime);
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		orderServiceImpl.addOrderDao(order);
		this.getAll(request, response);
	}
		
	public void init() throws ServletException {
		// Put your code here
	}

}
