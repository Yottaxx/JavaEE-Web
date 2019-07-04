package com.example.eeprojecttrue.Entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Collect")
public class Collect implements Serializable{
	
	/*private static final long serialVersionUID = 3524215936351012384L;
	@Id
	private CollectId collectId;

	public CollectId getCollectId() {
	return collectId;
}
public void setCollectId(CollectId collectId) {
	this.collectId = collectId;
}
public Collect(CollectId collectId) {
	super();
	this.collectId = collectId;
}
public Collect() {
	super();
}*/
	
	
	//正常的收藏********************
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
    
	private Integer customerId;
	
	private Integer goodsId;
	public Collect() {
		super();
	}
	public Collect(Integer customerId, Integer goodsId) {
		super();
		this.customerId = customerId;
		this.goodsId = goodsId;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	

	
	
	
	
}
