package com.mytoken.Strategy;

/**
 * description
 *
 * @author lou
 * @create 2023/6/15
 */
public class BadFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("bad fly");
    }
}
