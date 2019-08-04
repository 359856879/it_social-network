package com.czxy.dao;

import com.czxy.domain.LEmailsend;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.Mapper;

/**
 * 发送 邮件
 */
@org.apache.ibatis.annotations.Mapper
public interface LEmailsendMapper extends Mapper<LEmailsend> {


    @Delete("truncate table l_emailsend")
    void deleteLES();
}
