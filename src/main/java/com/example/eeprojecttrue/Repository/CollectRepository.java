package com.example.eeprojecttrue.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Collect;

@Repository
public interface CollectRepository  extends CrudRepository<Collect,Integer>{
	
	List<Collect> findByCustomerId(int customerId);
    List<Collect> findByGoodsId(int goodsId);
    List<Collect> findAll(); 
    Collect findByCustomerIdAndGoodsId(int customerId,int goodsId);
    Collect findById(int id);
    
    void deleteById(int id);
    
    
	
	/*
	List<Collect> findByCustomerId(int customerId);
    List<Collect> findByGoodsId(int goodsId);
    List<Collect> findAll(); 
    Collect findByCustomerIdAndGoodsId(int customerId,int goodsId);
    */
}
