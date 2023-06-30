package com.mytoken.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * description
 *
 * @author lou
 * @create 2023/6/19
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在接受消息...");
        Socket socket = serverSocket.accept();
        Socket socket2 = serverSocket.accept();
        System.out.println("1");
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }

    }
}
