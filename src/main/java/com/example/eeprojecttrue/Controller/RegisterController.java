package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/register")
    public String newUser( @RequestParam(name="logo",required=false) MultipartFile logo,Customer customer,
                          HttpServletRequest request) throws IOException {
        System.out.println("post");
        customer.setLogo(logo);
        if(customerService.Save(customer)) {
            HttpSession session=request.getSession();
            Customer customer1=customerService.findByEmail(customer.getEmail());
            session.setAttribute("customer",customer1);
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
