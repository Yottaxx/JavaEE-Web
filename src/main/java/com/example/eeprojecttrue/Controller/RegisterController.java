package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public String newUser(Customer customer, HttpServletRequest request)
    {
        System.out.println("post");
        if(customerService.Save(customer)) {
            HttpSession session=request.getSession();
<<<<<<< HEAD
            Customer customer1=customerService.findByEmail(customer.getEmail());
            session.setAttribute("customer",customer1);
=======
            session.setAttribute("customer",customer);
>>>>>>> ad5ddffab0f25a2405bdfcab5902afeea4d01260
            return "redirect:/index";

        }else
            return "aboutus";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String newUser2(Customer customer)
    {
        System.out.println("get");
       return "signup";
    }


}
