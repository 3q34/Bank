package day15IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cdx on 2019/7/2.
 * desc:
 */
public class TestFileStream {
    private static final String TAG = "TestFileStream";

    @Test
    //读取写入
    public void test4() throws IOException {
        File file = new File("D:\\1.txt");
        File file1 = new File("D:\\2.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);

        byte[] b = new byte[30];
        int len;
        while ((len = fileInputStream.read(b)) != -1) {
            //fileOutputStream.write(b);//这样写可能会把空余的字节写入到新文件中30个字节
            fileOutputStream.write(b, 0, len);//源文件有几个字节就是几个字节
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void test3() throws IOException {
        File file = new File("D:\\1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] b = new String("I love china").getBytes();
        fileOutputStream.write(b);//若存在，覆盖。
        fileOutputStream.close();
    }

    @Test
    public void test2() throws IOException {
        File file = new File("D:\\1.txt");
        if (!file.exists())
            file.createNewFile();

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] b = new byte[30];
        int len;
        while ((len = fileInputStream.read(b)) != -1) {
            for (int a : b)
                System.out.print((char) a);
        }
        fileInputStream.close();
    }

    @Test
    //从硬盘读取文件到程序
    public void test1() {
        File file = new File("D:\\1.txt");
        FileInputStream fileInputStream = null;
        try {
            if (!file.exists())
                file.createNewFile();

            fileInputStream = new FileInputStream(file);
            int b;
            while ((b = fileInputStream.read()) != -1) {
                System.out.print((char) b);
                //b = fileInputStream.read();
            }
        } catch (IOException e) {

        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
            }
        }

    }

    @Test
    //从硬盘读取文件到程序
    public void test() throws IOException {
        File file = new File("D:\\1.txt");
        if (!file.exists())
            file.createNewFile();

        FileInputStream fileInputStream = new FileInputStream(file);
        int b = fileInputStream.read();
        while (b != -1) {
            System.out.print((char) b);
            b = fileInputStream.read();
        }

    }
}
