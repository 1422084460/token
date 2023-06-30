package com.mytoken.test;

/**
 * description
 *
 * @author lou
 * @create 2023/6/14
 */
public class Man extends Person{
    @Override
    void accept(Action action) {
        action.getResult(this);
    }
}
