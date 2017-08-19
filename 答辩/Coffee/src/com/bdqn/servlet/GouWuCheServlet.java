package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.entity.Coffee;
import com.bdqn.entity.GouWuChe;
import com.bdqn.entity.Menu;
import com.bdqn.entity.User;
import com.bdqn.service.impl.CoffeeServiceImpl;
import com.bdqn.service.impl.GouWuCheServiceImpl;

public class GouWuCheServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GouWuCheServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("gouWuChe")){
			this.gouWuChe(request, response);
		}else if(flag.equals("list")){
			this.gouWuCheList(request, response);
		}else if(flag.equals("delete")){
			this.gouWuCheDelete(request, response);
		}else if(flag.equals("finash")){
			this.finash(request, response);
		}else if(flag.equals("xiadan")){
			this.xiadan(request, response);
		}else if(flag.equals("gouWuChe2")){
			this.gouWuChe2(request, response);
		}
		}
		//点击添加商品到购物车
		public void gouWuChe2(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			int coffeeNo = Integer.parseInt(request.getParameter("coffeeNo"));
			int pronum = Integer.parseInt(request.getParameter("pronum"));
			HashMap<Integer, Coffee> car = (HashMap<Integer, Coffee>) request.getSession().getAttribute("car");
			car.remove(coffeeNo);
			Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(coffeeNo);
			coffee.setCoffeeNum(pronum);
			request.getSession().setAttribute("coffee", coffee);
			response.sendRedirect("XingChen/newaddPayment.jsp");
		}
		//购物车下单
		public void xiadan(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			int proNum=Integer.parseInt(request.getParameter("proNum"));
			request.setAttribute("proNum",proNum);
			request.getRequestDispatcher("XingChen/newaddPayment.jsp");
		}
		public void finash(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.removeAttribute("car");
			response.sendRedirect("XingChen/success_payment.jsp");
		}
		//点击添加商品到购物车
		public void gouWuChe(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			Coffee coffee = new CoffeeServiceImpl().getCoffeeByNo(Integer.parseInt(request.getParameter("coffeeNo")));		
			HashMap<Integer, Coffee> car;
			HttpSession session = request.getSession();
			User user;
			if(session.getAttribute("user")==null){
				user = new User();
			}else{
				user = (User) session.getAttribute("user");
			}
			coffee.setBuyerId(user.getId());
			Integer coffeeNo = new Integer(coffee.getCoffeeNo());
			if(session.getAttribute("car") == null){
				car = new HashMap<Integer, Coffee>();
			}else{
				car = (HashMap<Integer, Coffee>) session.getAttribute("car");
			}
			if(car.get(coffeeNo)==null){
				car.put(coffeeNo, coffee);
			}else{
				int oldNum = car.get(coffeeNo).getCoffeeNum();
				car.get(coffeeNo).setCoffeeNum(oldNum+1);
				car.get(coffeeNo).setBuyerId(user.getId());
			}
			session.setAttribute("car", car);
			response.sendRedirect("XingChen/shopping.jsp");
		}
		//购物车所有信息
		public void gouWuCheList(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			HashMap<Integer, Coffee> car = null;
			HttpSession session = request.getSession();
			if(session.getAttribute("car") == null){
				car = new HashMap<Integer, Coffee>();
			}else{
				car = (HashMap<Integer, Coffee>) session.getAttribute("car");
			}
			session.setAttribute("car", car);
			response.sendRedirect("XingChen/shopping.jsp");
		}
		//删除购物车信息
		public void gouWuCheDelete(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			int coffeeNo = Integer.parseInt(request.getParameter("coffeeNo"));
			HttpSession session = request.getSession();
			User user;
			if(session.getAttribute("user")==null){
				user = new User();
			}else{
				user = (User) session.getAttribute("user");
			}			HashMap<Integer, Coffee> car;
			car = (HashMap<Integer, Coffee>) session.getAttribute("car");
			car.remove(new Integer(coffeeNo));
			session.setAttribute("car", car);
			response.sendRedirect("XingChen/shopping.jsp");
		}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
