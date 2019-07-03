package com.example.eeprojecttrue.Controller;

import com.example.eeprojecttrue.Entity.C_M;
import com.example.eeprojecttrue.Entity.Comment;
import com.example.eeprojecttrue.Entity.Customer;
import com.example.eeprojecttrue.Entity.Moment;
import com.example.eeprojecttrue.Service.CommentService;
import com.example.eeprojecttrue.Service.CustomerService;
import com.example.eeprojecttrue.Service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private MomentService momentService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CommentService commentService;
    @GetMapping(value = {"/blogdetails.html"})
    public String ChatHtml(HttpSession session, Model model){

        return "blogdetails";
    }

    @GetMapping(value = {"/detail"})
    public String comment(int moment_id, Model model){

        Moment moment=momentService.findById(moment_id);
        Customer customer=moment.getCustomer();
        model.addAttribute("detail",new C_M(customer,moment));
        List<Comment> comments=moment.getComments();
        model.addAttribute("comments",comments);
        List<Moment> moments=momentService.GetByDate(6,0);
        List<Integer> integers = new LinkedList<>();
        for(int i=0;i<moments.size();i++)
        {
            integers.add(moments.get(i).getCustomer().getId());
        }
        System.out.println("detail");
        model.addAttribute("img",integers);
        model.addAttribute("title",moments);
        return "blogdetails";
    }


    @PostMapping(value = {"/newcomment"})
    public String NewMoment(int moment_id, Comment comment,HttpSession session)
    {
        if(comment.getContent()!=null)
        {
            Customer customer= (Customer) session.getAttribute("customer");
            System.out.println(moment_id);
            Moment moment= momentService.findById(moment_id);
            comment.setMoment(moment);
            comment.setCustomer_id(customer.getId());
            comment.setCustomer_name(customer.getName());
            comment.setF_moment_id(moment_id);
            comment.setDate(new Date());
            commentService.Save(comment);
            comment= (Comment) commentService.findById(comment.getId());
            momentService.addComment(moment,comment);
           return "redirect:/detail?moment_id="+moment_id;
        }
        return "redirect:/chat";
    }


    @PostMapping(value = {"/new_children_comment"})
    public String NewChildren_Comment(int comment_id, Comment comment,HttpSession session)
    {
        if(comment.getContent()!=null)
        {
            Customer customer= (Customer) session.getAttribute("customer");
            System.out.println("comment:"+comment_id);
            Comment comment_father= commentService.findById(comment_id);
            comment.setParent(comment_father);
            comment.setCustomer_name(customer.getName());
            comment.setCustomer_id(customer.getId());
            comment.setF_moment_id(comment_father.getF_moment_id());
            comment.setFather_id(comment_id);
            comment.setDate(new Date());
            commentService.Save(comment);
            comment= (Comment) commentService.findById(comment.getId());
            commentService.addS_Coments(comment_father,comment);
            commentService.Save(comment_father);
            return "redirect:/detail?moment_id="+comment.getF_moment_id();
        }
        return "redirect:/chat";
    }


}
