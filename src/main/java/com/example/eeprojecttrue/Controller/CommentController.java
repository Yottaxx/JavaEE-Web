package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.C_M;
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

@Controller
public class CommentController {
    @Autowired
    private MomentService momentService;
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = {"/blogdetails.html"})
    public String ChatHtml(HttpSession session, Model model){

        return "blogdetails";
    }

    @GetMapping(value = {"/detail"})
    public String comment(int moment_id, Model model){

        Moment moment=momentService.findById(moment_id);
        Customer customer=moment.getCustomer();
        model.addAttribute("detail",new C_M(customer,moment));
        return "blogdetails";
    }
}
