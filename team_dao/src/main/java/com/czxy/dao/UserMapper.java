package com.czxy.dao;

import com.czxy.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @version v 1.0
 * @date 2019/7/29
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {


    @Update("update l_user set userflname=#{userflname},useremail=#{email},username=#{username},userpassword=#{password},userphoto=#{img} where userid=#{id} ")
    public void updates(@Param("userflname") String userflname,@Param("email") String email,@Param("username") String username,@Param("password") String password,@Param("img") String img,@Param("id") Integer id);
}
