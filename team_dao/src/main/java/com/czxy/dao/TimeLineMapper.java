package com.czxy.dao;

import com.czxy.domain.TimeLine;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface TimeLineMapper extends Mapper<TimeLine> {

    /**
     * 将时间线对象添加到数据库
     * @param timeLine
     */
//    @Insert("INSERT INTO 'i_timeline'(timelineid,timeline,info,userIid,userYid,discussid,receiveemailid,sendemailid) values (null,#{timeline},#{info},#{userIid},#{userYid},#{discussid},#{receiveemailid},#{sendemailid})")
//    public void add(TimeLine timeLine);


    /**
     * 根据当前用户主键查询到当前用户的事件
     * @param userIid
     * @return
     */
    @Select("select * from i_timeline where userIid = #{userIid} ORDER BY timeline desc")
    List<TimeLine> findAll(Integer userIid);


}
