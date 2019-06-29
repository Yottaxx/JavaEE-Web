/**
 * 
 */
package com.example.eeprojecttrue.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eeprojecttrue.Entity.Customer_assue_Commodity;
import com.example.eeprojecttrue.Repository.AssueRepository;


/**
 * @author Yan Wanli
 *
 */
@Service
public class AssueService {
	 @Autowired
	    private AssueRepository assueRepository;
	 
	 public Customer_assue_Commodity findById(int id)
	    {
	        return assueRepository.findById(id);
	    }
}
