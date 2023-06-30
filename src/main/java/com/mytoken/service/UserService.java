package com.mytoken.service;

import com.mytoken.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> queryUser();

    public User queryUserByNameAndPwd(String userName,String password);
}
