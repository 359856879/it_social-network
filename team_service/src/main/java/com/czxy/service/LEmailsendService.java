package com.czxy.service;

import com.czxy.domain.LEmailsend;

import java.util.List;

public interface LEmailsendService {

    /**
     * 添加 发送邮件对象
     * @param lEmailsend
     * @return
     */
    void addLES(LEmailsend lEmailsend);


    /**
     * 查询所有  发送邮件
     * @return
     */
    List<LEmailsend> findLES();


    /**
     * 删除 发送的邮件
     * @param
     */
    void deleteLES();
}
