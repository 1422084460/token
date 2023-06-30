package com.mytoken.test;

/**
 * description
 * 具体访问者
 * @author lou
 * @create 2023/6/14
 */
public class Success extends Action{
    @Override
    void getResult(Man man) {
        System.out.println("man:success");
    }

    @Override
    void getResult(Woman woman) {
        System.out.println("woman:success");
    }
}
