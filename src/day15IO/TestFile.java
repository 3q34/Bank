package day15IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by cdx on 2019/7/1.
 * desc:凡是输入输出相关的类、接口都定义在java.IO下
 * 创建、删除、重命名。但是涉及文件内容的file类不能实现，必须使用IOStream
 */
public class TestFile {
    private static final String TAG = "TestFile";

    public static void main(String[] args) {


    }

    @Test
    public void test() {
        File file = new File("D:/pingall.log");

        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        File file1 = new File("hahah.txt");
        // boolean b= file1.renameTo(new File("D:/pingall.log"));
        //System.out.println(b);

    }

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\1.txt");
        if (file.exists())
            System.out.println(file.delete());
        else System.out.println(file.createNewFile());
        File file1 = new File("D:\\IO\\1");
        if (!file1.exists())
            System.out.println(file1.mkdirs());//创建文件目录，不是文件。
        // 若上层文件目录存在。使用mkdir(),若不存在，则使用mkdirs()
        File file2=new File("D:\\IO\\1");
        for (String s : file2.list()) {
            System.out.println(s);
        }
        for (File listFile : file2.listFiles()) {
            System.out.println(listFile.getName());
        }


    }

}
