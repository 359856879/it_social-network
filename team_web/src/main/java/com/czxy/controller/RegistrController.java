package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("R")
public class RegistrController {

    //私有化Service
    @Resource
    private UserService userService;

    //注册逻辑方法
    @PostMapping("Register/{id}")
    public ResponseEntity<Void> Register(HttpServletRequest request , User user , @PathVariable String id ,String[] jineng ,String[] hobby){
        //获取到的数组
//        System.out.println(Arrays.toString(jineng));
//        System.out.println(Arrays.toString(hobby));
//        System.out.println("最先获取到的对象:"+user);

        //新建一个User对象
        User user1 = new User();
        //把用户输入的登录名和密码保存进去
        user1.setUserid(null); //赋值表中的id
        user1.setUsertypeid(Integer.parseInt(id)); //赋值用户选择的类型
        user1.setUsername(user.getUsername()); // 赋值用户的登录名
        user1.setUserpassword(user.getUserpassword()); //赋值用户的密码
        user1.setUserregister(new Date()); //赋值注册的的时间
        user1.setUsernickname(user.getUsernickname()); //赋值用户的昵称
        user1.setUseremail(user.getUseremail()); //赋值用户的邮箱
//        System.out.println("添加完毕的user对象:"+user1);

        //获取该用户的技能
        //创建一个技能字符串
        String ji = "";
        //遍历这个数组并转换成String字符串拼接到相对应的对象中
        for (String s : jineng) {
            ji += s+",";
        }
//        System.out.println("打印技能遍历添入的字符串:"+ji);
        user1.setUserskills(ji); //赋值用户的技能

        //获取该用户的爱好
        //创建一个字符串
        String hobbys = "";
        //遍历爱好数组并转换成字符串
        for (String h : hobby) {
            hobbys += h+",";
        }
        user1.setUserhobby(hobbys);

        user1.setUserlp(new Date());
        user1.setUserap(new Date());


        //调用service里添加的方法 把这个对象添加进去
        try {
            userService.addUser(user1);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    //判断登录名是否和库中的重复了
    @GetMapping("getUsername")
    public ResponseEntity<Void> getUsername(String name){
        System.out.println("传递过来的用户名:"+name);

        boolean user = userService.getUser(name);
        System.out.println("结果:"+user);
        if(user){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
