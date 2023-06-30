package com.mytoken.service;

import com.mytoken.mapper.UserMapper;
import com.mytoken.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUser() {
        return null;
    }

    @Override
    public User queryUserByNameAndPwd(String userName,String password) {
        return userMapper.queryUserByNameAndPwd(userName, password);
    }
}
