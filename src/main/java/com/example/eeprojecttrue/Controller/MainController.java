package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Repository.CustomerRepository;
import com.example.eeprojecttrue.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController  {

    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/index")
    public String getIndex(Model model,HttpSession httpSession) {
        Customer customer= (Customer) httpSession.getAttribute("customer");
        customer=customerService.findByEmail(customer.getEmail());
        if(customer.getName()!=null)
            model.addAttribute("user",customer.getName());
        else
            model.addAttribute("user","PLEASE LOGIN");
        return "index";
    }

    @RequestMapping(value = "/signup")
    public String getSignUpHtml() {
        return "signup";
    }

    @RequestMapping(value = "/index.html")
    public String getIndexHtml(Model model,HttpSession httpSession) {
        Customer customer= (Customer) httpSession.getAttribute("customer");
        customer=customerService.findByEmail(customer.getEmail());
        if(customer.getName()!=null)
            model.addAttribute("user",customer.getName());
        else
            model.addAttribute("user","PLEASE LOGIN");
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

    @RequestMapping(value = "/portfolio.html")
    public String GetPortfolioHtml() {
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


    @RequestMapping(value = "/tttest",method = RequestMethod.GET)
    public String newUser2(Model model)
    {
       model.addAttribute("post","sdfsdf");
       return "test";
    }


}
