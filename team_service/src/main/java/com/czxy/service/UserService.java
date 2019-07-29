package com.czxy.service;

import com.czxy.domain.User;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/29 13:52
 * @Description:
 */
public interface UserService {



    public User  findUser(Integer id);

    public void update(User user,String img,Integer id);

}