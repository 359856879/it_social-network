package com.czxy.service.lmpl;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    //实现登陆的方法
    @Override
    public User loginUser(String name, String pass) {
        //查询 l_user 数据库里所有的数据
        List<User> list = userMapper.selectAll();
        //遍历数据库判断是否和用户输入的一致如一致返回这个对象不一致返回 Null
        for (User user : list) {
            if(user.getUsername().equals(name) && user.getUserpassword().equals(pass)){
                return user;
            }
        }
        return null;
    }



    //实现注册的方法
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    //查询数据库中所有的数据
    @Override
    public boolean getUser(String name) {
        List<User> list = userMapper.selectAll();
        for (User user : list) {
            if(user.getUsername().equals(name)){
                return false;
            }
        }
        return true;
    }

    //更新登录的ip
    @Override
    public void updateUserIP(User user) {
        userMapper.updateByPrimaryKey(user);
    }

}