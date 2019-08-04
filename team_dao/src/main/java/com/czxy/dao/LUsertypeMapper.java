package com.czxy.dao;

import com.czxy.domain.LUsertype;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *  用户类型表
 *
 */
@org.apache.ibatis.annotations.Mapper
public interface LUsertypeMapper extends Mapper<LUsertype> {

    @Select("select * from l_usertype where utypeid = #{utypeid}")
    List<LUsertype> findLUById(Integer utypeid);
}
