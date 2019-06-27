package com.example.eeprojecttrue.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController  {

    @RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
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
}
