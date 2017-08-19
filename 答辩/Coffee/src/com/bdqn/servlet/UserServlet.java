package com.bdqn.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdqn.entity.User;
import com.bdqn.service.impl.CoffeeServiceImpl;
import com.bdqn.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
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
		if(flag.equals("register")){
			this.register(request, response);
		}else if(flag.equals("userLogin")){
			this.userLogin(request, response);
		}else if(flag.equals("logout")){
			this.logout(request, response);
		}else if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("getDetail")){
			this.getDetail(request, response);
		}else if(flag.equals("perUser")){
			this.getperUser(request, response);
		}else if(flag.equals("isAdmin")){
			this.isAdmin(request, response);
		}else if(flag.equals("notLogin")){
			this.notLogin(request, response);
		}
		
		
	}
	/**
	 * 用户名注册
	 */
	public void adminNo(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String adminNo1=request.getParameter("flag");
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		ArrayList<User> users=userServiceImpl.getAll();
		int a=2;
		for(User user:users){
			if(user.getUserName().equals(adminNo1)){
				a=3;
			}
		}
		if(a==2){
			
		}else{
			response.getWriter().print("0");//0表示用户名已经被注册
		}
		
	}
	/**
	 * 用户登录
	 */
	public void notLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("msg", "请先登陆账号！");
		response.sendRedirect("../login/login.jsp");
	}
	/**
	 * 管理员登录
	 */
	public void isAdmin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("msg", "请先登陆管理员！");
		response.sendRedirect("../login/login.jsp");
	}
	//获取单个会员信息
	public void getperUser(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User user=new User();
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setRealName(request.getParameter("realname"));
		user.setIdCard(request.getParameter("idCard"));
		user.setPhone(request.getParameter("phone"));
		userServiceImpl.updateUser(Integer.parseInt(request.getParameter("id")), user);
		request.getSession().setAttribute("user",user );
		response.sendRedirect("XingChen/success_updateUser.jsp");
		
	}
	/**
	 * 后台查看
	 */
	public void getDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		User user = new UserServiceImpl().getUserById(Integer.parseInt(request.getParameter("id")));
		request.getSession().setAttribute("usert", user);
		response.sendRedirect("admin/detailUser.jsp");
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
		int totalCount = new UserServiceImpl().getAll().size();
		if(totalCount==0){
			totalCount=1;
		}
		System.out.println();
		int pageCount = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
		List<User> users = new UserServiceImpl().getUserList(pageIndex, pageSize);
		request.getSession().setAttribute("pageIndex", pageIndex);
		request.getSession().setAttribute("pageCount", pageCount);
		request.getSession().setAttribute("users", users);
		response.sendRedirect("admin/listUser.jsp");
	}
	/**
	 * 前台显示
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeAttribute("msg");
		response.sendRedirect("XingChen/index.jsp");
	}
	/**
	 * 登录提示
	 */
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = userServiceImpl.getUser(userName, password);
		
		if(user != null){
				user.setStatu(0);
				session.setAttribute("user", user);
				response.sendRedirect("XingChen/index.jsp");
		}else{
			session.setAttribute("msg", "用户名和密码不一致");
			response.sendRedirect("login/login.jsp");
		}
	}
	/**
	 * 前台登录后显示
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		HttpSession session = request.getSession();
		User user = new User();
		user.setIdCard(request.getParameter("idCard"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		user.setRealName(request.getParameter("realName"));
		user.setUserName(request.getParameter("userName"));
		int flag = userServiceImpl.addUser(user);
		if(flag > 0){
			session.setAttribute("user", user);
			response.sendRedirect("XingChen/index.jsp");
		}else{
			response.sendRedirect("register/userRegister.jsp");
		}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
