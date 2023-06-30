package com.mytoken.Strategy;

/**
 * description
 *
 * @author lou
 * @create 2023/6/15
 */
public abstract class Duck {

    FlyBehavior flyBehavior;

    public void fly(){
        if (flyBehavior != null){
            flyBehavior.fly();
        }
    }
}
