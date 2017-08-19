package com.bdqn.entity;
/**
 * 购物车实体类
 */
public class GouWuChe {
	private int menuNo;//编号
	private String userName;//用户名
	private String proName;//产品名称
	private String proPrice;//产品价格
	
	
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
