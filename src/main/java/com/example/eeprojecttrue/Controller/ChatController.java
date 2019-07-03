package com.example.eeprojecttrue.Controller;


import com.example.eeprojecttrue.Entity.C_M;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Service.CustomerService;
import com.example.eeprojecttrue.Service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MomentService momentService;
    @Autowired
    private CustomerService customerService;
    @GetMapping(value = {"/blogthree.html"})
    public String ChatHtml(HttpSession session,Model model){
        ReMoment(-1,model,0,null);
        return "blogthree";
    }

    @GetMapping(value = {"/blogthree"})
    public String Chat(HttpSession session,Model model){
        ReMoment(-1,model,0,null);
        return "blogthree";
    }



    @PostMapping(value = {"/newmoment"})
    public String NewMoment(@RequestParam(name="logo",required=false) MultipartFile logo,Moment moment, Model model,
                            HttpSession session)
    {
        if(moment.getContent()!=null)
        {
            Customer customer= (Customer) session.getAttribute("customer");
            Date date=new Date();
            moment.setDate(date);
            moment.setCustomer(customer);
            moment.setLogo(logo);
            momentService.Save(moment);
            moment= (Moment) momentService.findById(moment.getId());
            customerService.addMoments(customer,moment);
            ReMoment(-1,model,0,null);
            return "/blogthree";

//            List<Moment> list=momentService.GetByDate(10,0);
//          //  List<Moment> list=momentService.findByDateStartsWith(new Date());
//
//            C_M []c_ms=new C_M[list.size()];
//            Moment temp;
//            for(int i=0;i<list.size();i++)
//            {
//                temp= list.get(i);
//                c_ms[i]=new C_M(temp.getCustomer(),temp);
//            }
//
//            model.addAttribute("data",c_ms);
//            return "/blogthree";
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
    public String NewMomentsDay(Model model,HttpSession httpSession)
    {
        Integer num=-1;
        httpSession.setAttribute("time",num);
        httpSession.setAttribute("page",0);
        return "redirect:/chat";
    }

    @GetMapping(value = "/newmoment/week")
    public String NewMomentsWeek(Model model,HttpSession httpSession)
    {
        Integer num=-7;
        httpSession.setAttribute("time",num);
        httpSession.setAttribute("page",0);
        return "redirect:/chat";
    }

    @GetMapping(value = "/newmoment/month")
    public String NewMomentsMonth(Model model,HttpSession httpSession)
    {
        Date date=new Date();
        Calendar now=Calendar.getInstance();
        now.setTime(date);
        int maxDate = 0-now.get(Calendar.DATE);
        Integer num=maxDate;
        httpSession.setAttribute("time",maxDate);
        httpSession.setAttribute("page",0);
        return "redirect:/chat";
    }

    @GetMapping(value = "/chat")
    public String Char_Main(Model model,HttpSession httpSession) {

        int a= (int) httpSession.getAttribute("time");
        int pages=(int) httpSession.getAttribute("page");
        ReMoment(a,model,pages,null);



        return "/blogthree";
    }

    private void ReMoment(int time, Model model,int pages,String tag)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, time); //得到前一天
        Date date1 = calendar.getTime();
        List<Moment> list;
        if(tag==null) {
            list=momentService.GetByDate(10,pages);
        } else {
            list=momentService.GetByDateAndTag(10,pages,tag);
        }
        //  List<Moment> list=momentService.findByDateStartsWith(new Date());
        //朋友圈信息
        C_M []c_ms=new C_M[list.size()];
        Moment temp;
        for(int i=0;i<list.size();i++)
        {
            temp= list.get(i);
            if(temp.getDate().after(date1))
                c_ms[i]=new C_M(temp.getCustomer(),temp);
        }
        //最近用户图片id
        List<Integer> integers = new LinkedList<>();
        List<Moment> moments=momentService.GetByDate(6,0);
        for(int i=0;i<moments.size();i++)
        {
            integers.add(moments.get(i).getCustomer().getId());
        }
        model.addAttribute("data",c_ms);
        System.out.println("detail");
        model.addAttribute("img",integers);

    }


    @GetMapping(value = "/Moment/return/{id}")
    public String MomentOperation(@PathVariable("id") int id)
    {
        Moment moment=momentService.findById(id);
        return "index";
    }

    @GetMapping(value = "/Moment/get")
    public String MomentOperation_type2( int id)
    {
        Moment moment=momentService.findById(id);
        return "index";
    }

    @GetMapping(value = "/Moment/awesome")
    public void MomentOperation_plus( int id)
    {
       momentService.awesome(id);
    }




    @GetMapping(value = "/Moment/page/{page}")
    public String MomentOperation_type2(@PathVariable("page") int page, HttpSession httpSession)
    {
        httpSession.setAttribute("time",-1);
        httpSession.setAttribute("page",page);
        return "redirect:/chat";
    }



    @GetMapping(value = "Customer/image/get")
    public ResponseEntity<byte[]> Image_Customer(int id, HttpServletResponse res)
    {
        byte[] data=customerService.findById(id).getLogo();
//            InputStream inputStream=new BufferedInputStream(new ByteArrayInputStream(data));
//            int len=inputStream.available();
//            byte[] buffer=new byte[len];
            res.setContentType("image/jpeg");
            res.setCharacterEncoding("UTF-8");
//            OutputStream os=new BufferedOutputStream(res.getOutputStream());
//            os.write(buffer);
//            os.flush();
//            os.close();
            return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(value = "Moment/image/get")
    public ResponseEntity<byte[]> Image_Moment(int id, HttpServletResponse res)
    {
        res.setContentType("image/jpeg");
        res.setCharacterEncoding("UTF-8");
        byte[] data=momentService.findById(id).getLogo();
        return new ResponseEntity<>(data, HttpStatus.OK);

    }

    @GetMapping(value = "Moment/title/get")
    public ResponseEntity<String> Tile_Moment(int id, HttpServletResponse res)
    {
        res.setCharacterEncoding("UTF-8");
        String title=momentService.findById(id).getTitle();
        return new ResponseEntity<>(title, HttpStatus.OK);

    }

    @GetMapping(value = "/MomentGetByTag")
    public String MomentOperation_typeTag( String tag,Model model)
    {
        ReMoment(-1,model,0,tag);
        return "blogthree";
    }

    @GetMapping(value = "/MomentAwesome")
    public @ResponseBody int MomentOperation_typeTag(int moment_id)
    {
        System.out.println(moment_id);
       return  momentService.awesome(moment_id);

    }

    @GetMapping(value = "/MomentAwesome_sub")
    public @ResponseBody int MomentOperation_type_awe(int moment_id)
    {
        System.out.println(moment_id);
        return  momentService.no_awesome(moment_id);

    }


    @GetMapping(value = "/MomentGetByContent")
    public String MomentOperation_typeContent( String content,Model model)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date1 = calendar.getTime();
        List<Moment> list;
        System.out.println(content);
        if(content==null) {
            list=momentService.GetByDate(10,0);
        } else {
            list=momentService.GetByDateAndContent(10,0,content);
        }
        //  List<Moment> list=momentService.findByDateStartsWith(new Date());
        //朋友圈信息
        C_M []c_ms=new C_M[list.size()];
        Moment temp;
        for(int i=0;i<list.size();i++)
        {
            temp= list.get(i);
            if(temp.getDate().after(date1))
                c_ms[i]=new C_M(temp.getCustomer(),temp);
        }
        //最近用户图片id
        List<Integer> integers = new LinkedList<>();
        List<Moment> moments=momentService.GetByDate(6,0);
        for(int i=0;i<moments.size();i++)
        {
            integers.add(moments.get(i).getCustomer().getId());
        }
        model.addAttribute("data",c_ms);
        System.out.println("detail");
        model.addAttribute("img",integers);
        return "blogthree";
    }


    @GetMapping(value = "/MomentGetByLike")
    public String MomentOperation_typeContent(Model model,HttpSession session)
    {
        Customer customer= (Customer) session.getAttribute("customer");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); //得到前一天
        Date date1 = calendar.getTime();
        List<Moment> list=new LinkedList<>();

        List<Customer> customers=customerService.inCluster(customer);
        List<Moment> small_list;

        for(Customer cus:customers)
        {
            small_list=momentService.findByCustomerId(cus.getId());
            for(Moment moment:small_list)
            {
                list.add(moment);
            }
        }

        C_M []c_ms=new C_M[list.size()];
        Moment temp;
        for(int i=0;i<list.size();i++)
        {
            temp= list.get(i);
            if(temp.getDate().after(date1))
                c_ms[i]=new C_M(temp.getCustomer(),temp);
        }
        //最近用户图片id
        List<Integer> integers = new LinkedList<>();
        List<Moment> moments=momentService.GetByDate(6,0);
        for(int i=0;i<moments.size();i++)
        {
            integers.add(moments.get(i).getCustomer().getId());
        }
        model.addAttribute("data",c_ms);
        System.out.println("detail");
        model.addAttribute("img",integers);
        return "blogthree";
    }
}
