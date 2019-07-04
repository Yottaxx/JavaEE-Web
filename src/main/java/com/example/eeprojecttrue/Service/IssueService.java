package com.example.eeprojecttrue.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Issue;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import com.example.eeprojecttrue.Repository.GoodsRepository;
import com.example.eeprojecttrue.Repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
    private IssueRepository issueRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private GoodsRepository goodsRepository;
	
	public List<Issue> findByCustomerId(int customerId){
		return issueRepository.findByCustomerId(customerId);
	}
    public Issue findByGoodsId(int goodsId) {
    	return issueRepository.findByGoodsId(goodsId);
    }
    public List<Issue> findAll(){
    	return issueRepository.findAll();
    }
    
    public Date findDateByGoodsId(int goodsId) {
    	Issue issue = issueRepository.findDateByGoodsId(goodsId);
    	return issue.getIssueDate();
    }
    
    public Customer findCustomerByGoodsId(int goodsId) {
    	int customer_id = issueRepository.findByGoodsId(goodsId).getCustomerId();
    	Customer customer = customerRepository.findById(customer_id);
    	return customer;
    }
    
    
}
