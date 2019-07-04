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
	    
	    @RequestMapping(value = "/second-hand")
	    public String getSecondHand() {
	        return "second-hand";
	    }
	    @RequestMapping(value = "/second-hand.html")
	    public String getSignUpSecondHandHtml() {
	        return "second-hand";
	    }

	    @RequestMapping(value = "/secone-hand-issue")
	    public String getIssue() {
	        return "secone-hand-issue";
	    }
	    @RequestMapping(value = "/secone-hand-issue.html")
	    public String getIssueHtml() {
	        return "secone-hand-issue";
	    }
	    @RequestMapping(value = "/portfoliotwo")
	    public String getMine() {
	        return "portfoliotwo";
	    }
	    @RequestMapping(value = "/portfoliotwo.html")
	    public String getMineHtml() {
	        return "portfoliotwo";
	    }

	  

}
