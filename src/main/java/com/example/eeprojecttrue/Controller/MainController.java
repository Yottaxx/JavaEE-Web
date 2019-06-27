package com.example.eeprojecttrue.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController  {

    @RequestMapping(value = "/index")
    public String getIndex() {
        return "index";
    }


}
