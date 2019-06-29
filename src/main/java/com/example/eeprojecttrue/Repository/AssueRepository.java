/**
 * 
 */
package com.example.eeprojecttrue.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eeprojecttrue.Entity.Customer_assue_Commodity;

/**
 * @author Yan Wanli
 *
 */
@Repository
public interface AssueRepository extends CrudRepository<Customer_assue_Commodity,Integer>{
	
	Customer_assue_Commodity findById(int id); 
	
	

}
