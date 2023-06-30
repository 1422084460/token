package com.mytoken.test;

/**
 * description
 * 抽象访问者 visitor
 * @author lou
 * @create 2023/6/14
 */
public abstract class Action {

    abstract void getResult(Man man);

    abstract void getResult(Woman woman);
}
