package com.example.eeprojecttrue.Entity;

import java.util.Date;
import java.sql.Timestamp;

public class C_G {
	//private Goods goods;
	private Integer isCollect;
	private Integer id;
	private String name;
	private Double price;
	private String describe1;
	private String portrait = "\\target\\classes\\static\\images\\portrait\\defaultPortrait.png";
	private Integer isOnSale = 1;
	private String goodsType="books";
	private String area;
	private String portrait2;
	private String portrait3;
	private Integer customerid;
	private byte[] picture1;
	private byte[] picture2;
	private byte[] picture3;
	
	
	
	public C_G(Goods goods, int isCollect) {
		super();
		this.id = goods.getId();
		this.name = goods.getName();
		this.price = goods.getPrice();
		this.describe1 = goods.getDescribe1();
		this.portrait = goods.getPortrait();
		this.portrait2 = goods.getPortrait2();
		this.portrait3 = goods.getPortrait3();
		this.isOnSale = goods.getIsOnSale();
		this.goodsType = goods.getGoodsType();
		this.area = goods.getArea();
		this.customerid = goods.getCustomerid();
		this.isCollect = isCollect;
		this.picture1 = goods.getPicture1();
		this.picture2 = goods.getPicture2();
		this.picture3 = goods.getPicture3();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescribe1() {
		return describe1;
	}

	public void setDescribe1(String describe1) {
		this.describe1 = describe1;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public Integer getIsOnSale() {
		return isOnSale;
	}

	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPortrait2() {
		return portrait2;
	}

	public void setPortrait2(String portrait2) {
		this.portrait2 = portrait2;
	}

	public String getPortrait3() {
		return portrait3;
	}

	public void setPortrait3(String portrait3) {
		this.portrait3 = portrait3;
	}

	

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public byte[] getPicture1() {
		return picture1;
	}

	public void setPicture1(byte[] picture1) {
		this.picture1 = picture1;
	}

	public byte[] getPicture2() {
		return picture2;
	}

	public void setPicture2(byte[] picture2) {
		this.picture2 = picture2;
	}

	public byte[] getPicture3() {
		return picture3;
	}

	public void setPicture3(byte[] picture3) {
		this.picture3 = picture3;
	}

	public void setIsCollect(Integer isCollect) {
		this.isCollect = isCollect;
	}

	public int getIsCollect() {
		return isCollect;
	}
	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}

	@Override
	public String toString() {
		return "C_G [isCollect=" + isCollect + ", id=" + id + ", name=" + name + ", price=" + price + ", describe1="
				+ describe1 + ", portrait=" + portrait + ", isOnSale=" + isOnSale + ", goodsType=" + goodsType
				+ ", area=" + area + ", portrait2=" + portrait2 + ", portrait3=" + portrait3 + ", customer_id="
				+ customerid + "]";
	}
	
	
	

}
