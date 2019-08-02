package com.czxy.service.lmpl;

import com.czxy.dao.DiscussMapper;
import com.czxy.service.DiscussService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 20:57
 * @Description:
 */
@Service
@Transactional
public class DiscussServicelmpl implements DiscussService {

    @Resource
    private DiscussMapper discussMapper;



}