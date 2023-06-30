package com.mytoken.pojo;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String phoneNum;
    private double money;
    private Integer status;
}
