package com.example.eeprojecttrue.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class SessionConfiguration implements  WebMvcConfigurer {
    @Autowired
    private SecurityInterceptor securityInterceptor;
@Override
public void  addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(securityInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register",
            "/css/**","/images/**","/js/**","/fonts/**","/static/**","/pricing");
}

}
