package com.mytoken.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * description
 *
 * @author lou
 * @create 2023/6/14
 */
public class Client {

    public static void main(String[] args) throws IOException {
//        Action success = new Success();
//        Person man = new Man();
//        Person woman = new Woman();
//        ObjectStructure objectStructure = new ObjectStructure();
//        objectStructure.attach(man);
//        objectStructure.attach(woman);
//        objectStructure.attach(man);
//        objectStructure.display(success);

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.close();
        socket.close();
    }
}
