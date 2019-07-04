package com.example.eeprojecttrue.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eeprojecttrue.Entity.Collect;
import com.example.eeprojecttrue.Repository.CollectRepository;


@Service
public class CollectService {
	
	@Autowired
	private CollectRepository collectRepository;
	
	
	public boolean Save(Collect collect)
    {
		System.out.println("执行save函数if外");
		int customerId = collect.getCustomerId();
		int goodsId = collect.getGoodsId();
		//if(collectRepository.findByCustomerId(customerId).getGoodsId() != goodsId) {
			System.out.println("执行save函数if内");
			collectRepository.save(collect);
			return true;
		//}
       //return false;
    }
	
	public boolean Delete(Collect collect) {
		System.out.println("执行delete函数if外");
		//if(collect.getCustomerId()!=null) {
			System.out.println("执行delete函数if内");
			Collect collect1 = collectRepository.findByCustomerIdAndGoodsId(collect.getCustomerId(),collect.getGoodsId());
			collectRepository.delete(collect1);
			return true;
		//}
		//return false;
	}
	
	public Collect findByCustomerIdAndGoodsId(int customerId,int goodsId) {
		return collectRepository.findByCustomerIdAndGoodsId(customerId,goodsId);
	}
	
	public List<Collect> findByCustomerId(int customerId){
		
		return collectRepository.findByCustomerId(customerId);
	}
	
    public List<Collect> findByGoodsId(int goodsId){
    	
    	return collectRepository.findByGoodsId(goodsId);
    	
    }
    public List<Collect> findAll(){
    	
    	return collectRepository.findAll();
    	
    }
    
    public void deleteById(int id)
    {
    	collectRepository.deleteById(id);
    }
    
	
	/*public boolean Save(Collect collect)
    {
		System.out.println("执行save函数if外");
		if(collect.getCollectId()!=null) {
			System.out.println("执行save函数if内");
			collectRepository.save(collect);
			return true;
		}
       return false;
    }
	
	public boolean Delete(Collect collect) {
		System.out.println("执行delete函数if外");
		if(collect.getCollectId()!=null) {
			System.out.println("执行delete函数if内");
			collectRepository.delete(collect);
			return true;
		}
		return false;
	}
	public List<Collect> findByCustomerId(CollectId collectId){
		return collectRepository.findByCustomerId(collectId);
	}
    public List<Collect> findByGoodsId(CollectId collectId){
    	return collectRepository.findByGoodsId(collectId);
    }
    public List<Collect> findAll(){
    	return collectRepository.findAll();
    }
    public Collect findByCustomerIdAndGoodsId(CollectId collectId) {
    	return collectRepository.findByCustomerIdAndGoodsId(collectId);
    }*/
	
	

}
