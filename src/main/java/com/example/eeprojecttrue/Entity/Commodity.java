package com.example.eeprojecttrue.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Commodity")

public class Commodity {
	
@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int com_id;
	private String com_name;
	private String com_kid;
	private String com_price;
	private String com_decribe;
	private String com_com_area;
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_kid() {
		return com_kid;
	}
	public void setCom_kid(String com_kid) {
		this.com_kid = com_kid;
	}
	public String getCom_price() {
		return com_price;
	}
	public void setCom_price(String com_price) {
		this.com_price = com_price;
	}
	public String getCom_decribe() {
		return com_decribe;
	}
	public void setCom_decribe(String com_decribe) {
		this.com_decribe = com_decribe;
	}
	public String getCom_com_area() {
		return com_com_area;
	}
	public void setCom_com_area(String com_com_area) {
		this.com_com_area = com_com_area;
	}
	

}
