package com.hehe.chat;

import com.hehe.Entity.user;
import com.hehe.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class LoginController {

    @Autowired
    public userService queryservice;
    /**
     * 登陆界面
     */
    @GetMapping("/")
    public ModelAndView login() {

        return new ModelAndView("/login");
    }

    /**
     * 聊天界面
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam("userId")String userId,@RequestParam("password")String password, HttpServletRequest request) throws UnknownHostException {
        //原本是username 现在改动成id
        //调取数据
        //这里进行数据库的验证 登陆账号登陆
        String username="匿名用户";//初始化成匿名用户
        if (StringUtils.isEmpty(userId))
        {
            System.out.println("这里是测试是否存在用户:"+userId);
            userId = "无";
        }
        else
        {
            user usertemple=queryservice.findByUserId(userId);
            //System.out.println("这里是测试显示用户："+usertemple.toString());
            if(usertemple==null)
            {
                System.out.println("没有此用户");
            }
            else {
                if(!usertemple.getPassWord().equals(password))
                {
                    System.out.println("密码验证错误");
                    ModelAndView mav = new ModelAndView("/loginfail");
                    return mav;
                }
                else
                {
                    username=usertemple.getUserName();
                    userId=usertemple.getUserId();
                }
            }
        }
        ModelAndView mav = new ModelAndView("/chat");
        mav.addObject("username", username);
        mav.addObject("userId",userId);
        mav.addObject("webSocketUrl", "ws://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/chat");

        return mav;
    }



}
