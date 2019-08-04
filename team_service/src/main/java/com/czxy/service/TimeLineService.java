package com.czxy.service;

import com.czxy.domain.TimeLine;

import java.util.List;

public interface TimeLineService {

    //    //通过用户id 查找登录用户
    List<TimeLine> findUserById(Integer userid);

    //添加时间线对象
    void add(Integer userid, String info);

    //删除事件
    void delete(Integer timelineid);


}
