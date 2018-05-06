package io;

import java.io.*;

/**
 * Description:
 * Created by jiangwang3 on 2018/3/6.
 */
public class ReadFile {

    private static final String readFileName = "C:\\Users\\jiangwang3\\Desktop\\read.txt";

    public static void main(String[] args) throws Exception{
        easyReadFile();
//        bufferReadFile();
//        streamReadFile();
//        bufferStreamReadFile();

    }


    private static void bufferStreamReadFile() throws Exception{
        //读取文件(字符流)
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName),"utf-8"));
        //读取数据
        //循环取出数据
        String str ;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
        }

        //关闭流
        in.close();
    }

    private static void streamReadFile() throws Exception{
        //读取文件(字节流)
        Reader in = new InputStreamReader(new FileInputStream(readFileName),"utf-8");
        //读取数据
        //循环取出数据
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println(len);
        }
        //关闭流
        in.close();
    }


    private static void bufferReadFile() throws Exception{
        //读取文件(缓存字节流)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(readFileName));
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n ;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"utf-8");
            System.out.println(str);
        }
        //关闭流
        in.close();
    }
    /**
     * 无修饰
     * @author jiangwang
     * 11:57 2018/3/6
     */
    private static void easyReadFile() throws Exception{
        //读取文件(字节流)
        InputStream in = new FileInputStream(readFileName);
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"utf-8");
            System.out.println(str);
        }
        //关闭流
        in.close();
    }
}
