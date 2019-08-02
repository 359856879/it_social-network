package com.czxy.dao;

import com.czxy.domain.Discuss;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Auther: 传智新星
 * @Date: 2019/8/1 20:56
 * @Description:
 */
@org.apache.ibatis.annotations.Mapper
public interface DiscussMapper extends Mapper<Discuss> {


    @Select("SELECT IFNULL(MAX(discusslevel),0) FROM l_discuss WHERE todiscussid = #{id}")
    public Integer checkLevel(@Param("id") Integer id);

    @Select("select * from l_discuss where discusslevel=#{discusslevel} and upuserid=#{upuserid} and todiscussid=#{todiscussid}")
    public List<Discuss> findAll(@Param("discusslevel") Integer discusslevel,@Param("upuserid") Integer upuserid,@Param("todiscussid") Integer todiscussid);


}