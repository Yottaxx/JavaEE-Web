/**
 * 
 */
package com.example.eeprojecttrue.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.eeprojecttrue.Entity.Commodity;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CommodityService;
import com.example.eeprojecttrue.Service.CustomerService;

/**
 * @author Yan Wanli
 *
 */
@Controller
public class IssueController {
	 @Autowired
	    private CommodityService commodityService;
	 
	 @PostMapping(value = "/commit")
	 public String newCommodity( Commodity commodity, HttpServletRequest request)
	    {
	        System.out.println("post");
	        if(commodityService.Save(commodity)) {
	            HttpSession session=request.getSession();
	            session.setAttribute("commodity",commodity);
	            return "redirect:/secondHand";

	        }else
	            return "secone-hand-issue";
	    }

	 
}
