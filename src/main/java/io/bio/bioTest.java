package io.bio;

import java.io.*;

public class bioTest {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream=new FileOutputStream("/home/illumwang/Documents/testio.txt",true);
        //append追加
        outputStream.write("111helloagain".getBytes());
        //flush和close的区别
        //fd状态0--sys.in/scanf 1--sys.out 2---sys.err
        //opentoomanyfiles错误
        ///etc/security/limits.conf设置最大文件数(软硬链接 )
        //linux中有一个fd
        outputStream.close();
        outputStream.flush();

        InputStream inputStream=new FileInputStream("/home/illumwang/Documents/testio.txt");
        //读取到缓冲区里,按字节读取
        byte[] bs=new byte[inputStream.available()];
        int len=0;
        while((len= inputStream.read(bs))>0){
            System.out.println(new String(bs));
        }
        inputStream.close();
    }
}
