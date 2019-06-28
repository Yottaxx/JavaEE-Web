package com.example.eeprojecttrue.Interceptor;

import com.example.eeprojecttrue.Entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        HttpSession session = request.getSession();

//            判断是否已有该用户登录的session
        if(session.getAttribute("customer") != null){
            Customer customer= (Customer) session.getAttribute("customer");
            System.out.println(customer.getName()+" "+customer.getPassword());
            return true;
        }

//            跳转到登录页
        String url = "/login";
        response.sendRedirect(url);
        return false;
    }
}
