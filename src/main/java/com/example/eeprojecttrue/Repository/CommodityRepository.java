package com.example.eeprojecttrue.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Commodity;


@Repository
public interface CommodityRepository extends CrudRepository<Commodity, Integer> {
	 Commodity findById(int com_id);
	    List<Commodity> findAll();
}
