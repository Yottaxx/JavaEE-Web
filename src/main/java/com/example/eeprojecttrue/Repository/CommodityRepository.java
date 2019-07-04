package com.example.eeprojecttrue.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Goods;



@Repository
public interface CommodityRepository extends CrudRepository<Goods, Integer> {
	 Goods findById(int com_id);
	    List<Goods> findAll();
	    //@Query(value = "select g from Goods g WHERE customer_id=11")
	    List<Goods> findByCustomerid(int customer_id);
	    void deleteById(int id);
}
