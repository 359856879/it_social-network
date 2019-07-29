package com.czxy.service.lmpl;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: 传智新星
 * @Date: 2019/7/29 13:53
 * @Description:
 */
@Service
@Transactional
public class UserServicelmpl implements UserService {


    @Resource
    private UserMapper userMapper;


    @Override
    public User findUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);

        return user;
    }

    @Override
    public void update(User user, String img,Integer id) {

        //调用工程的方法,实现更新
        userMapper.updates(user.getUserflname(),user.getUseremail(),user.getUsername(),user.getUserpassword(),img,id);

    }


}