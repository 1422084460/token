package com.mytoken.mapper;

import com.mytoken.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    //public List<User> queryUser();

    public User queryUserByNameAndPwd(@Param("userName") String userName,@Param("password") String password);
}
