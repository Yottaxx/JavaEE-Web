package com.example.eeprojecttrue.Controller;


import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Service.CustomerService;
import com.example.eeprojecttrue.Service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MomentService momentService;
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = {"/blogthree.html"})
    public String ChatHtml(HttpSession session){
        Customer customer= (Customer) session.getAttribute("customer");

        return "blogthree";
    }

    @GetMapping(value = {"/blogthree"})
    public String Chat(HttpSession session){
        return "blogthree";
    }

    @PostMapping(value = {"/newmoment"})
    public String NewMoment(Moment moment, Model model,HttpSession session)
    {
        if(moment.getContent()!=null)
        {
            Customer customer= (Customer) session.getAttribute("customer");
            Date date=new Date();
            moment.setDate(date.toString());
            moment.setCustomer(customer);
            momentService.Save(moment);
            moment= (Moment) momentService.findById(moment.getId());

           customerService.addMoments(customer,moment);

            List<Moment> list=momentService.GetByDate();

            model.addAttribute("moment",list);
            model.addAttribute("customer",customer);
            return "/blogthree";
        }
        else
            return "newmoment";
    }

    @GetMapping(value = {"/newmoment"})
    public String NewMoments(Moment moment)
    {
        return "newmoment";
    }
}
