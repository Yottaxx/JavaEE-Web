package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController  {

    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/signup")
    public String getSignUpHtml() {
        return "signup";
    }

    @RequestMapping(value = "/index.html")
    public String getIndexHtml() {
        return "index";
    }

    @RequestMapping(value = "/aboutus.html")
    public String getAboutus() {
        return "aboutus";
    }

    @RequestMapping(value = "/over")
    public String test() {
        return "index";
    }

    @RequestMapping(value = "/tests")
    public String tests() {
        return "test";
    }

    @RequestMapping(value = "/portfolio")
    public String GetPortfolio() {
        return "portfolio";
    }


    @RequestMapping(value = "/blogdetails")
    public String GetBlogdetails() {
        return "blogdetails";
    }

    @RequestMapping(value = "/pricing")
    public String GetPricing() {
        return "pricing";
    }
}
