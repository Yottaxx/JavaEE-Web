package com.example.eeprojecttrue.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Goods;
import com.example.eeprojecttrue.Repository.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsRepository goodsRepository;
	
	
	 public boolean Save(Goods goods){
	        Goods GR=goodsRepository.findByDescribe1(goods.getDescribe1());
	        if(GR==null)
	        {
	            goodsRepository.save(goods);
	            return true;
	        }
	        if( GR.getName() == null) {
	            goodsRepository.save(goods);
	            return true;
	        }
	        else
	            return false;
	    }
	 
	 public List<Goods> findByName(String name){
		 
		 return goodsRepository.findByName(name);
		 
	 }
	 public Goods findByDescribe(String describe1) {
		 return goodsRepository.findByDescribe1(describe1);
	 }
	 public Goods findById(int id) {
		 //System.out.println(goodsRepository.findById(1));
		 return goodsRepository.findById(id);
	 }
	 public List<Goods> findAll(){
		 return goodsRepository.findAll();
	 }
	
//	public boolean Change(int id,String name,double price,String describe,String portrait,int isOnsale,String goodsType) {
//		
//		int i = goodsRepository.deleteGoods(id);
//		if(i > 0) {
//			Goods goods = new Goods(name,price,describe,portrait,isOnsale,goodsType);
//			int j = goodsRepository.addGoods(name,price,describe,portrait,isOnsale,goodsType);
//			if(j>0) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean DeleteGoods(int id) {
//		int i = goodsRepository.deleteGoods(id);
//		if(i > 0) {
//			return true;
//		}
//		return false;
//	}

}
