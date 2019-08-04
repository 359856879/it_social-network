package com.czxy.service;

import com.czxy.domain.LEmailreceive;

import java.util.List;

public interface LEmailreceiveService {

    /**
     * 查询所有 接收邮件
     * @return
     */
    List<LEmailreceive> findAllLER(Integer receiveuserid);


    /**
     * 查询  接受邮件  个数
     * @return
     */
    Integer findLERCount(Integer receiveuserid);



    /**
     * 查询  接受 草案 邮件  个数
     * @return
     */
    Integer findLERDrCount(Integer receiveuserid);



    /**
     * 查询  接受 已发送 邮件  个数
     * @return
     */
    Integer findLERSeCount(Integer receiveuserid);
//
//
//
//    /**
//     * 查询  接受 垃圾  邮件  个数
//     * @return
//     */
//    Integer findLERTrCount(Integer receiveuserid);



    /**
     * 添加  邮件
     * @param lEmailreceive
     */
    void addLER(LEmailreceive lEmailreceive);



    /**
     * 根据状态 查询  接收邮件
     * @return
     */
    List<LEmailreceive> findAllLERByStatus(Integer receiveuserid, Integer receiveemailstatus);


    /**
     * 修改 邮件状态值
     * @param receiveemailid
     */
    void update(Integer receiveemailid);
}
