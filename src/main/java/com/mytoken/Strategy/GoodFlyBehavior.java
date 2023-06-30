package com.mytoken.Strategy;

/**
 * description
 *
 * @author lou
 * @create 2023/6/15
 */
public class GoodFlyBehavior implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("good fly");
    }
}
