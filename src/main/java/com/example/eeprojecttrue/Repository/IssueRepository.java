package com.example.eeprojecttrue.Repository;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Issue;

@Repository
public interface IssueRepository extends CrudRepository<Issue,Integer> {
	List<Issue> findByCustomerId(int customerId);
    Issue findByGoodsId(int goodsId);
    //Customer findById(int id);
    List<Issue> findAll(); 
    Issue findDateByGoodsId(int goodsId);
}
