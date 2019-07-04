package com.example.eeprojecttrue.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Goods;

@Repository
public interface GoodsRepository extends CrudRepository<Goods,Integer> {
	
	List<Goods> findByName(String name);
    Goods findByDescribe1(String describe1);
    Goods findById(int id);
    List<Goods> findAll();
}
