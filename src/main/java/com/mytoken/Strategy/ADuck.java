package com.mytoken.Strategy;

/**
 * description
 *
 * @author lou
 * @create 2023/6/15
 */
public class ADuck extends Duck{

    public ADuck(){
        flyBehavior = new GoodFlyBehavior();
    }
}
