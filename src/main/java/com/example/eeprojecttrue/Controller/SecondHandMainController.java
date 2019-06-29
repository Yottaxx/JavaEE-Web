/**
 * 
 */
package com.example.eeprojecttrue.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CommodityService;
import com.example.eeprojecttrue.Service.CustomerService;

/**
 * @author Yan Wanli
 *
 */
@Controller
public class SecondHandMainController {
	
	 @Autowired
	    private CustomerService customerService;
	    private CommodityService commodityService;
	    
	    @RequestMapping(value = "/secondHand")
	    public String getSecondHand() {
	        return "secondHand";
	    }
	    @RequestMapping(value = "/secondHand.html")
	    public String getSignUpSecondHandHtml() {
	        return "secondHand";
	    }

	    @RequestMapping(value = "secone-hand-issue")
	    public String getIssue() {
	        return "secone-hand-issue";
	    }
	    @RequestMapping(value = "/secone-hand-issue.html")
	    public String getIssueHtml() {
	        return "secone-hand-issue";
	    }

	  

}
