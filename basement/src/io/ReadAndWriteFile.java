package io;

import java.io.*;

/**
 * Description:
 * Created by jiangwang3 on 2018/3/6.
 */
public class ReadAndWriteFile {

    private static final String readFileName = "C:\\Users\\jiangwang3\\Desktop\\read.txt";

    private static final String writeFileName = "C:\\Users\\jiangwang3\\Desktop\\write.txt";

    public static void main(String[] args) throws Exception{
//        easyReadFile();
//        bufferReadFile();
        streamReadFile();
        bufferStreamReadFile();

    }

    private static void printReafFile() throws Exception{
        //读取文件(字节流)
        Reader in = new InputStreamReader(new FileInputStream(readFileName),"utf-8");
        //写入相应的文件
        PrintWriter out = new PrintWriter(new FileWriter(writeFileName));
        //读取数据
        //循环取出数据
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println(len);
            //写入相关文件
            out.write(len);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }

    private static void bufferStreamReadFile() throws Exception{
        //读取文件(字符流)
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(readFileName),"utf-8"));
        //BufferedReader in = new BufferedReader(new FileReader("d:\\1.txt")));
        //写入相应的文件
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writeFileName),"utf-8"));
        //BufferedWriter out = new BufferedWriter(new FileWriter("d:\\2.txt"))；
        //读取数据
        //循环取出数据
        String str ;
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            //写入相关文件
            out.write(str);
            out.newLine();
        }

        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }

    private static void streamReadFile() throws Exception{
        //读取文件(字节流)
        InputStreamReader in = new InputStreamReader(new FileInputStream(readFileName),"utf-8");
        //写入相应的文件
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(writeFileName));
        //读取数据
        //循环取出数据
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = in.read()) != -1) {
            System.out.println(len);
            //写入相关文件
            out.write(len);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }


    private static void bufferReadFile() throws Exception{
        //读取文件(缓存字节流)
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(readFileName));
        //写入相应的文件
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(writeFileName));
        //读取数据
        //一次性取多少字节
        byte[] bytes = new byte[2048];
        //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
        int n = -1;
        //循环取出数据
        while ((n = in.read(bytes,0,bytes.length)) != -1) {
            //转换成字符串
            String str = new String(bytes,0,n,"utf-8");
            System.out.println(str);
            //写入相关文件
            out.write(bytes, 0, n);
        }
        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }
    /**
     * 无修饰
     * @author jiangwang
     * 11:57 2018/3/6
     */
    private static void easyReadFile() throws Exception{
        //读取文件(字节流)
        InputStream in = new FileInputStream(readFileName);
        //写入相应的文件
        OutputStream out = new FileOutputStream(writeFileName);
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
            //写入相关文件
            out.write(bytes, 0, n);
        }
        //关闭流
        in.close();
        out.close();
    }
}
