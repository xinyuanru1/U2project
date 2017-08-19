package com.bdqn.entity;
/**
 * 订单实体类
 */
public class Menu {
	private int menuNo;//编号
	private String userName;//用户名
	private String proName;//产品名称
	private String proPrice;//产品单价
	private String userPhone;//用户电话
	private String userAddress;//用户地址
	private String menuStatu;//订单状态
	private int proNum;//商品数量
	private String proTotalPrice;//商品总价
	
	public String getMenuStatu() {
		return menuStatu;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getProTotalPrice() {
		return proTotalPrice;
	}
	public void setProTotalPrice(String proTotalPrice) {
		this.proTotalPrice = proTotalPrice;
	}
	public void setMenuStatu(String menuStatu) {
		this.menuStatu = menuStatu;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProPrice() {
		return proPrice;
	}
	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}
	
}
