package com.mytoken.test;

import java.util.Date;

/**
 * description
 *
 * @author lou
 * @create 2023/6/14
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
