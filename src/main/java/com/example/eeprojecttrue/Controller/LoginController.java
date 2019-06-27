package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/Login")
    public String newUser(Customer customer)
    {
        if(customerService.Login(customer))
            return "index";
        else
            return "signup";
    }
}
