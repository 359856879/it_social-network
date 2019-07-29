package com.czxy.service.lmpl;

import com.czxy.dao.UserMapper;
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


}