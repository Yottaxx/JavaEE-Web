package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public String newUser(Customer customer)
    {
        System.out.println("post");
        if(customerService.Save(customer))
            return "index";
        else
            return "aboutus";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String newUser2(Customer customer)
    {
        System.out.println("get");
        if(customerService.Save(customer)) {
            System.out.println("in");
            return "index";
        }else
        {
            System.out.println("out");
            return "aboutus";
        }
    }
}
