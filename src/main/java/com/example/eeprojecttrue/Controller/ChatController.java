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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
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
            moment.setDate(date);
            moment.setCustomer(customer);
            momentService.Save(moment);
            moment= (Moment) momentService.findById(moment.getId());
            customerService.addMoments(customer,moment);

            List<Moment> list=momentService.GetByDate();
          //  List<Moment> list=momentService.findByDateStartsWith(new Date());

            C_M []c_ms=new C_M[list.size()];
            Moment temp;
            for(int i=0;i<list.size();i++)
            {
                temp= list.get(i);
                c_ms[i]=new C_M(temp.getCustomer(),temp);
            }

            model.addAttribute("data",c_ms);
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

    @GetMapping(value = "/newmoment/day")
    public String NewMomentsDay(Model model)
    {
        ReMoment(-1,model);
        return "/blogthree";
    }

    @GetMapping(value = "/newmoment/week")
    public String NewMomentsWeek(Model model)
    {
        ReMoment(-7,model);
        return "/blogthree";
    }

    @GetMapping(value = "/newmoment/month")
    public String NewMomentsMonth(Model model)
    {
        Date date=new Date();
        Calendar now=Calendar.getInstance();
        now.setTime(date);
        int maxDate = 0-now.get(Calendar.DATE);
        ReMoment(maxDate,model);
        return "/blogthree";
    }


    private void ReMoment(int time, Model model)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, time); //得到前一天
        Date date1 = calendar.getTime();

        List<Moment> list=momentService.GetByDate();
        //  List<Moment> list=momentService.findByDateStartsWith(new Date());

        C_M []c_ms=new C_M[list.size()];
        Moment temp;
        for(int i=0;i<list.size();i++)
        {
            temp= list.get(i);
            if(temp.getDate().after(date1))
                c_ms[i]=new C_M(temp.getCustomer(),temp);
        }

        model.addAttribute("data",c_ms);
    }


    @GetMapping(value = "/Moment/return/{id}")
    public String MomentOperation(@PathVariable("id") int id)
    {
        Moment moment=momentService.findById(id);
        return "index";
    }

    @GetMapping(value = "/Moment/get")
    public String MomentOperation_type2(int id)
    {
        Moment moment=momentService.findById(id);
        return "index";
    }
}
