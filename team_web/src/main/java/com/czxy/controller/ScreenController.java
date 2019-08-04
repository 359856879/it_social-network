package com.czxy.controller;

import com.czxy.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("S")
public class ScreenController {

    //获取域中的对象的密码
    @GetMapping("login")
    public ResponseEntity<Void> login(HttpServletRequest request, String pas){
        System.out.println("传递过来的密码:"+pas);
        //获取域中的对象
        User user = (User) request.getSession().getAttribute("user");
        //判断这个对象的密码是否用户输入的一致
        if(pas.equals(user.getUserpassword())){
            //返回状态吗200
            System.out.println("返回锁屏对象:"+user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        //返回500状态码以判断
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //获取域中的对象
    @GetMapping("getUser")
    public ResponseEntity<User> getUser(HttpServletRequest request){
        //获取域中的对象
        User user = (User) request.getSession().getAttribute("user");
        //把这个对象直接返回页面
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
