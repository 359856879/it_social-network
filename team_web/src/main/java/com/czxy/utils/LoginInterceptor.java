package com.czxy.utils;

import com.czxy.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取浏览器访问的路径
        String Url = request.getRequestURI();
        System.out.println("访问的路径:"+Url);
        //获取域中的对象
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("从域中获取的对象:"+user);
        //判断域中是否有对象
        if(user != null){
            return true;
        }
        if(Url.contains("login") || Url.contains("css") || Url.contains("font") || Url.contains("ico")
                ||Url.contains("img") || Url.contains("js")||Url.contains("lay")||Url.contains("register.html")||Url.contains("R")){
            return true;
        }


        response.sendRedirect("login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
