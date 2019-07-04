package com.example.eeprojecttrue.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eeprojecttrue.Entity.Goods;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Repository.CommodityRepository;


@Service
public class CommodityService {
	 @Autowired
	    private CommodityRepository commodityRepository;
	 
	 public boolean Save(Goods commodity)
	    {
	       
	        	commodityRepository.save(commodity);
	            return true;
	       
	     
	    }
	    public Goods findById(int id)
	    {
	        return commodityRepository.findById(id);
	    }

	    public List<Goods> findAll()
	    {
	        return commodityRepository.findAll();
	    }
	    public List<Goods> findByCustomerID(int customer_id)
	    {
	        return commodityRepository.findByCustomerid(customer_id);
	    }
	    
	    public void  deleteById(int id)
	    {
	    	commodityRepository.deleteById(id);
	    }


}
