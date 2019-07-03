package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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
        File file=new File("/images/portfolio/project3.jpg");
        customer.setLogo(logo);
        if(logo.isEmpty())
            customer.setLogo((MultipartFile) file);
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

    @RequestMapping(value = "/re_register",method = RequestMethod.GET)
    public String reUser2( Model model,HttpSession session)
    {
        Customer customer= (Customer) session.getAttribute("customer");
        model.addAttribute("data",customer);
        return "signup_re";
    }

    @PostMapping(value = "/re_register")
    public String reUser(@RequestParam(name="logo",required=false) MultipartFile logo,Customer customer,HttpSession session)
    {
        Customer o_customer= (Customer) session.getAttribute("customer");

        if(customer.getLogo()!=null && customer.getLogo().length!=0)
        {
            o_customer.setLogo(logo);
        }

        if(customer.getName()!=null && !customer.getName().equals(""))
        {
            o_customer.setName(customer.getName());

        }

        if(customer.getPassword()!=null && !customer.getPassword().equals(""))
        {
            o_customer.setName(customer.getName());
        }


        customerService.reSave(o_customer);
        session.setAttribute("customer",o_customer);
        return "redirect:/index";
    }
}
