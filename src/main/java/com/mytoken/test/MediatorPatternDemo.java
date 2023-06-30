package com.mytoken.test;

/**
 * description
 *
 * @author lou
 * @create 2023/6/14
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
