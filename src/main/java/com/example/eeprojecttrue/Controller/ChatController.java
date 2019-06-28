package com.example.eeprojecttrue.Controller;


import com.example.eeprojecttrue.Entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ChatController {


    @GetMapping(value = {"/blogthree.html"})
    public String ChatHtml(HttpSession session){
        Customer customer= (Customer) session.getAttribute("customer");

        return "blogthree";
    }

    @GetMapping(value = {"/blogthree"})
    public String Chat(HttpSession session){
        return "blogthree";
    }
}
