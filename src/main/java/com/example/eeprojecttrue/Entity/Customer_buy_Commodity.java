package com.example.eeprojecttrue.Entity;

//import java.sql.Date;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Buy")
public class Customer_buy_Commodity {
	
@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int com_id;
	private Date buy_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCom_id() {
		return com_id;
	}
	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
	public Date getBuy_time() {
		return buy_time;
	}
	public void setBuy_time(Date buy_time) {
		this.buy_time = buy_time;
	}
	
	

}
