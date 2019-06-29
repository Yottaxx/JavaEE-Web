package com.example.eeprojecttrue.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Assue")
public class Customer_assue_Commodity {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private int com_id;
   private Date assue_time;
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
public Date getAssue_time() {
	return assue_time;
}
public void setAssue_time(Date assue_time) {
	this.assue_time = assue_time;
}
  

}
