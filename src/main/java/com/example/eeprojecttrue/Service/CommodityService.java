package com.example.eeprojecttrue.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eeprojecttrue.Entity.Commodity;
import com.example.eeprojecttrue.Repository.CommodityRepository;


@Service
public class CommodityService {
	 @Autowired
	    private CommodityRepository commodityRepository;

	   
	    public Commodity findById(int id)
	    {
	        return commodityRepository.findById(id);
	    }

	    public List<Commodity> findAll()
	    {
	        return commodityRepository.findAll();
	    }


}
