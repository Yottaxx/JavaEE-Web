package com.example.eeprojecttrue.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Goods")
public class Goods {// 商品类，记录二手物品属性
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Double price;
	private String describe1;
	private String portrait = "\\target\\classes\\static\\images\\portrait\\defaultPortrait.png";
	private Integer isOnSale = 1;
	private String goodsType;
	private String area;
	private String portrait2;
	private String portrait3;
	private Integer customerid;
	private byte[] picture1;
	private byte[] picture2;
	private byte[] picture3;

//	 @ManyToMany(fetch = FetchType.LAZY)
//	 @JoinTable(name = "customer_goods", joinColumns = { @JoinColumn(name = "like_goods_id") }, inverseJoinColumns = {@JoinColumn(name = "like_customer_id") })
//	 private List<Customer> likeCustomer;

	public Goods() {
		super();
	}

	public Goods(Integer id, String name, Double price, String describe1, String portrait, int isOnSale,
			String goodsType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.describe1 = describe1;
		this.portrait = portrait;
		this.isOnSale = isOnSale;
		this.goodsType = goodsType;
	}

	public Goods(String name, Double price, String describe1, String portrait, String goodsType) {
		super();
		// this.id = id;
		this.name = name;
		this.price = price;
		this.describe1 = describe1;
		this.portrait = portrait;
		this.isOnSale = 1;
		this.goodsType = goodsType;
	}

	public Goods(String name, Double price, String describe1, String portrait, int isOnSale, String goodsType) {
		super();
		this.name = name;
		this.price = price;
		this.describe1 = describe1;
		this.portrait = portrait;
		this.isOnSale = isOnSale;
		this.goodsType = goodsType;
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

	public int getIsOnSale() {
		return isOnSale;
	}

	public void setIsOnSale(int isOnSale) {
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

	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", describe=" + describe1 + ", portrait="
				+ portrait + ", isOnSale=" + isOnSale + ", goodsType=" + goodsType + "]";
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
	

}
