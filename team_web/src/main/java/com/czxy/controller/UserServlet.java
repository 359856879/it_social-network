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

/**
 * @Auther: 传智新星
 * @Date: 2019/7/29 13:54
 * @Description:
 */
@RestController
@RequestMapping("user")
public class UserServlet {


    @Resource
    private UserService userService;

    @GetMapping("/findUser")
    public ResponseEntity<User> findUser(HttpServletRequest request){


        try {
            //从session域中获取到user对象
            User user = (User) request.getSession().getAttribute("user");
            System.out.println("域中的对象:"+user);

            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }




    }
}