package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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

    /**
     *   获取展示页面需要展示的对象
     * @param request
     * @return
     */
    @GetMapping("/findUser")
    public ResponseEntity<User> findUser(HttpServletRequest request){


        try {
            //从session域中获取到user对象
            User user1 = userService.findUser(2);
            request.getSession().setAttribute("user",user1);

            System.out.println("域中的对象:"+user1);

            //把需要展示的对象返回
            return new ResponseEntity<>(user1,HttpStatus.OK);
        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


    @PostMapping("/updates")
    public ResponseEntity<Void> updateInfo(MultipartFile file,User user,HttpServletRequest request) throws IOException {

        System.out.println("需要更新对象user："+user);
        System.out.println(file.getOriginalFilename());

        //从域中获取到user对象
        User user1 = (User) request.getSession().getAttribute("user");
        System.out.println("域中对象user1:"+user1);

        //获取图片的名字
        String filename = file.getOriginalFilename();
        //下载图片进本地工程
        file.transferTo(new File("G:\\idea arc\\IDEAmaven\\team_work\\team_web\\src\\main\\resources\\static\\assets\\img\\it\\"+filename));

        //调用工程的方法实现更新部分属性的需求
        try {

            userService.update(user,"assets\\img\\it\\"+filename,user1.getUserid());

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }


}