package com.czxy.dao;


import com.czxy.domain.LEmailreceive;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 * 接受邮件  Mapper  接口
 * @author 94852
 */
@org.apache.ibatis.annotations.Mapper
public interface LEmailreceiveMapper extends Mapper<LEmailreceive> {


    /**
     * 查询  所有接受邮件  个数
     * @return
     */

    @Select("select count(receiveemailid) from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = 0")
    Integer findLERInCount(@Param("receiveuserid") Integer receiveuserid);


    /**
     * 查询  接受 草案 邮件  个数
     * @return
     */
    @Select("select count(receiveemailid) from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = 1")
    Integer findLERDrCount(@Param("receiveuserid") Integer receiveuserid);



    /**
     * 查询  接受 已发送 邮件  个数
     * @return
     */
    @Select("select count(receiveemailid) from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = 2")
    Integer findLERSeCount(@Param("receiveuserid") Integer receiveuserid);




    /**
     * 查询  接受 垃圾 邮件  个数
     * @return
     */
    @Select("select count(receiveemailid) from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = 3")
    Integer findLERTrCount(@Param("receiveuserid") Integer receiveuserid);





    /**
     * 查询所有  接收邮件
     * @return
     */
    @Select("select * from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = 0")
    @Results(id = "selectUser",value = {
            @Result(property = "receiveuserid" , column = "receiveuserid"),
            @Result(property = "user",one = @One(select = "com.czxy.dao.UserMapper.findUserById"), column = "receiveuserid")
    })
    List<LEmailreceive> findAllLER(@Param("receiveuserid") Integer receiveuserid);



    /**
     * 根据状态 查询  接收邮件
     * @return
     */
    @Select("select * from l_emailreceive where receiveuserid = #{receiveuserid} and receiveemailstatus = #{receiveemailstatus}")
    @ResultMap("selectUser")
    List<LEmailreceive> findAllLERByStatus(@Param("receiveuserid") Integer receiveuserid, @Param("receiveemailstatus") Integer receiveemailstatus);



    /**
     *
     *  修改  邮件状态
     */
    @Update("update l_emailreceive set receiveemailstatus = 3 where receiveemailid = #{receiveemailid}")
    void updateStatus(@Param("receiveemailid") Integer receiveemailid);
}
