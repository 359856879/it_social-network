package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

//获取本机的ip地址

@RestController
@RequestMapping("U")
public class LoginUserController {

    //私有化service
    @Resource
    private UserService userService;

    //登录逻辑方法
    @GetMapping("loginUser")
    public ResponseEntity<String> loginUser(User user , HttpServletRequest request) throws UnknownHostException {

        //获取当前的ip地址
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("本机的IP："+ ip.getHostAddress());

        //获取传递过来的用户对象并取出用户的登录名和密码
        User userlongin = userService.loginUser(user.getUsername(), user.getUserpassword());
        //多写一点让后面的人看的懂点我找到对象了的在这
        System.out.println("登录的对象:"+userlongin);

        //判断 userlongin 是否为空
        if(userlongin!= null){
            //此时不为空则把这个对象存放进域中以便于后续功能  存放名字为 User
            //把这个ip地址存放进该对象中
            userlongin.setUserip(ip.getHostAddress()+"");
            System.out.println("赋值了ip后:"+userlongin);
            userService.updateUserIP(userlongin);

            request.getSession().setAttribute("user",userlongin);
            //返回状态码 200
            return new ResponseEntity<>("okok",HttpStatus.OK);

        }
        //返回状态码 500
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
