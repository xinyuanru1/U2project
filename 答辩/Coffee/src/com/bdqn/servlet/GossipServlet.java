package com.bdqn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.bdqn.entity.Gossip;
import com.bdqn.entity.User;
import com.bdqn.service.impl.GossipServiceImpl;
import com.bdqn.service.impl.UserServiceImpl;
import com.bdqn.util.Page;

public class GossipServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GossipServlet() {
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
		if(flag.equals("add")){
			this.add(request, response);
		}else if(flag.equals("delete")){
			this.delete(request, response);
		}else if(flag.equals("getAll")){
			this.getAll(request, response);
		}else if(flag.equals("getForUpd")){
			this.getForUpd(request, response);
		}else if(flag.equals("update")){
			this.update(request, response);
		}else if(flag.equals("getDetail")){
			this.getDetail(request, response);
		}else if(flag.equals("getSome")){
			this.getSome(request, response);
		}else if(flag.equals("gossip")){
			this.qianGossip(request, response);
		}else if(flag.equals("qianAdd")){
			this.qianAdd(request, response);
		}else if(flag.equals("addGood")){
			this.addGood(request, response);
		}else if(flag.equals("addBad")){
			this.addBad(request, response);
		}else if(flag.equals("toReply")){
			this.toReply(request, response);
		}else if(flag.equals("doReply")){
			this.doReply(request, response);
		}
	}
	/**
	 * 后台留言回复
	 */
	public void doReply(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String reply = request.getParameter("replyContent");
		Gossip gossip = new GossipServiceImpl().getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		GossipServiceImpl gser = new GossipServiceImpl();
		gser.addReply(gossip, reply);
		this.getAll(request, response);
	}
	/**
	 * 后台留言回复
	 */
	public void toReply(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Gossip gossip = new GossipServiceImpl().getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		request.getSession().setAttribute("gossip", gossip);
		response.sendRedirect("admin/replyGossip.jsp");
	}
	/**
	 * 添加踩
	 */
	public void addBad(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GossipServiceImpl gser = new GossipServiceImpl();
		UserServiceImpl uuser = new UserServiceImpl();
		HttpSession session = request.getSession();
		Gossip gossip = gser.getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		User user = uuser.getUserById(Integer.parseInt(request.getParameter("userId")));
		gser.addBads(gossip);
		user.setStatu(1);
		uuser.updateUser(user.getId(), user);
		session.setAttribute("user", user);
		this.qianGossip(request, response);
	}
	/**
	 * 添加赞
	 */
	public void addGood(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		GossipServiceImpl gser = new GossipServiceImpl();
		UserServiceImpl uuser = new UserServiceImpl();
		HttpSession session = request.getSession();
		Gossip gossip = gser.getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		User user = uuser.getUserById(Integer.parseInt(request.getParameter("userId")));
		gser.addGoods(gossip);
		user.setStatu(1);
		uuser.updateUser(user.getId(), user);
		session.setAttribute("user", user);
		this.qianGossip(request, response);
	}
	//前台添加
	public void qianAdd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String gossipContent = request.getParameter("gossipContent");
		String goTitle = request.getParameter("goTitle");
		Gossip gossip = new Gossip();
		gossip.setGossipTitle(goTitle);
		gossip.setGossipContent(gossipContent);
		new GossipServiceImpl().addGossipDao(gossip);
		response.sendRedirect("XingChen/success_add_gossip.jsp");
		
	}
	//前台留言显示
	public void qianGossip(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageStr = request.getParameter("pageIndex");
		if(pageStr==null||pageStr.equals("")){
			pageStr = "1";
		}
		int pageIndex = Integer.parseInt(pageStr);
		int totalCount = new GossipServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int pageCount = (totalCount%5==0)?(totalCount/5):(totalCount/5+1);
		List<Gossip> gossips = new GossipServiceImpl().getGossips(pageIndex, 5);
		HttpSession session = request.getSession();
		session.setAttribute("gossips", gossips);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageCount", pageCount);
		response.sendRedirect("XingChen/gossip.jsp");
	}
	/**
	 * 后台分页
	 */
	public void getSome(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageStr = request.getParameter("pageIndex");
		if(pageStr==null||pageStr.equals("")){
			pageStr = "1";
		}
		int pageIndex = Integer.parseInt(pageStr);
		String text = request.getParameter("text");
		List<Gossip> gossips = new GossipServiceImpl().getSome(text, pageIndex, 2);
		int totalCount = new GossipServiceImpl().getSomeTotalCount(text);
		int pageCount = (totalCount%2==0)?(totalCount/2):(totalCount/2+1);
		HttpSession session = request.getSession();
		session.setAttribute("gossips", gossips);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("text", text);
		response.sendRedirect("admin/listSomeGossip.jsp");
	}
	/**
	 * 后台查看
	 */
	public void getDetail(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Gossip gossip = new GossipServiceImpl().getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		request.getSession().setAttribute("gossip", gossip);
		response.sendRedirect("admin/detailGossip.jsp");
	}
	/**
	 * 后台修改
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Gossip gossip = new Gossip();
		gossip.setGossipNo(Integer.parseInt(request.getParameter("gossipNo")));
		gossip.setGossipContent(request.getParameter("gossipContent"));
		gossip.setGossipTitle(request.getParameter("gossipTitle"));
		gossip.setReply(request.getParameter("reply"));
		new GossipServiceImpl().update(gossip);
		this.getAll(request, response);
	}
	/**
	 * 后台修改
	 */
	public void getForUpd(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		Gossip gossip = new GossipServiceImpl().getByNo(Integer.parseInt(request.getParameter("gossipNo")));
		request.getSession().setAttribute("gossip", gossip);
		response.sendRedirect("admin/updateGossip.jsp");
	}
	/**
	 * 后台分页
	 */
	public void getAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String pageStr = request.getParameter("pageIndex");
		if(pageStr==null||pageStr.equals("")){
			pageStr = "1";
		}
		int pageIndex = Integer.parseInt(pageStr);
		int totalCount = new GossipServiceImpl().getTotalCount();
		if(totalCount==0){
			totalCount=1;
		}
		int pageCount = (totalCount%2==0)?(totalCount/2):(totalCount/2+1);
		List<Gossip> gossips = new GossipServiceImpl().getGossips(pageIndex, 2);
		HttpSession session = request.getSession();
		session.setAttribute("gossips", gossips);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageCount", pageCount);
		response.sendRedirect("admin/listGossip.jsp");
	}
	/**
	 * 后台删除
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int gossipNo = Integer.parseInt(request.getParameter("gossipNo"));
		new GossipServiceImpl().deleteGossipDao(gossipNo);
		this.getAll(request, response);
	}
	/**
	 * 后台添加
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String gossipContent = request.getParameter("gossipContent");
		String gossipTitle = request.getParameter("gossipTitle");
		Gossip gossip = new Gossip();
		gossip.setGossipTitle(gossipTitle);
		gossip.setGossipContent(gossipContent);
		new GossipServiceImpl().addGossipDao(gossip);
		this.getAll(request, response);
		
	}
	public void init() throws ServletException {
		// Put your code here
	}
}
