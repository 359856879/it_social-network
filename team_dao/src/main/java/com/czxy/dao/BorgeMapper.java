package com.czxy.dao;

import com.czxy.domain.Borge;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @version v 1.0
 * @date 2019/8/1
 */
@org.apache.ibatis.annotations.Mapper
public interface BorgeMapper extends Mapper<Borge> {


    @Select("SELECT * FROM l_borge ORDER BY borgereadnum DESC LIMIT 0,4")
    public List<Borge> findHots();





}
