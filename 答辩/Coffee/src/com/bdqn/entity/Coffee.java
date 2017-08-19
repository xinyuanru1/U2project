package com.bdqn.entity;
/*
 * 咖啡实体类
 */
public class Coffee{
	private String coffeeType;//咖啡类别
	private int coffeeNo;//咖啡编号
	private String coffeeName;//咖啡名称
	private String coffeePrice;//咖啡单价
	private int coffeeNum;//购物车所记录咖啡个数
	private int buyerId;//购买人的ID
	private String picPath;//图片路径
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getCoffeeNum() {
		return coffeeNum;
	}
	public void setCoffeeNum(int coffeeNum) {
		this.coffeeNum = coffeeNum;
	}
	public String getCoffeeType() {
		return coffeeType;
	}
	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}
	public int getCoffeeNo() {
		return coffeeNo;
	}
	public void setCoffeeNo(int coffeeNo) {
		this.coffeeNo = coffeeNo;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(String coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public String getPicPath() {
		return picPath;
	}
	
}
