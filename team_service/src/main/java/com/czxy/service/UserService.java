package com.czxy.service;

import com.czxy.domain.User;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/29 13:52
 * @Description:
 */
public interface UserService {


    User findUserByMail(String useremail);

    public User  findUser(Integer id);

    public void update(User user,String img,Integer id);


    //登录
    User loginUser(String name,String pass);

    //注册
    void addUser(User user);

    //查询数据库中是否有相同的登录名
    boolean getUser(String name);

    //更新数据空中的ip
    void updateUserIP(User user);



}