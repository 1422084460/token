package com.mytoken.test;


import java.io.*;

/**
 * description
 *
 * @author lou
 * @create 2023/6/19
 */
public class IO {

    public static void main(String[] args) throws Exception {
//        File file = new File("D:\\111.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getParent());
//        System.out.println(file.length());
//        System.out.println(file.canWrite());
//        file.delete();
        //File file = new File("D:\\abc");
        //boolean b = file.mkdir();
        //System.out.println(b);
        //InputStream
        //Reader reader = new FileReader(file);
        //Writer writer = new FileWriter(file);
        IO.doo6();
    }


    public static void doo() throws IOException {
        File file = new File("D:\\111.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = 0;
        while ((data = fis.read())!=-1){
            System.out.print((char)data);
        }
    }

    public static void doo2() throws IOException {
        File file = new File("D:\\111.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = 0;
        byte[] b = new byte[8];
        while ((data = fis.read(b))!=-1){
            System.out.print(new String(b,0,data));
        }
    }

    public static void doo3() throws IOException {
        File file = new File("D:\\111.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        String s = "qwerty";
        fos.write(s.getBytes());
    }

    public static void doo4() throws IOException {
        File file = new File("D:\\111.txt");
        File file2 = new File("D:\\1111.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file2);
        byte[] b = new byte[1024];
        int data = 0;
        while ((data = fis.read(b))!=-1){
            fos.write(b);
        }
        System.out.println("copy ok");
    }

    public static void doo5() throws IOException {
        File file = new File("D:\\111.txt");
        File file2 = new File("D:\\1111.txt");

        FileReader fr = new FileReader(file);
        FileWriter fw = new FileWriter(file2);
        int data = 0;
        char[] c = new char[8];

        while ((data = fr.read(c))!=-1){
            fw.write(c,0,data);
        }
        fw.close();
    }

    public static void doo6() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\111.txt")));
        String len;
        while ((len = reader.readLine())!=null){
            System.out.println(len);
        }
        reader.close();

        //reader
    }
}
