package day15IO;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by cdx on 2019/7/5.
 * desc:随机访问和读取RandomAccessFile
 * 既可以充当输入流也可以充当输出流
 * 支持从文件的开头读取、写入
 * 支持从任意位置读取和写入（插入）
 */
public class TestRandomAccessFile {
    private static final String TAG = "TestRandomAccessFile";

    //插入，实际是将指针之后的元素取出来，将元素覆盖后，再将取出的元素写入
    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("D:\\3.txt", "rw");
            raf.seek(3);//指针到此位置
            StringBuffer st = new StringBuffer();
            byte[] b = new byte[10];
            int len;
            while ((len = raf.read(b)) != -1) {
                st.append(new String(b, 0, len));

            }
            raf.seek(3);//指针到此位置
            raf.write("xy".getBytes());//覆盖此位置两个字符
            raf.write(st.toString().getBytes());//覆盖此位置两个字符


        } catch (IOException e) {
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //插入（覆盖）
    @Test
    public void test1() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("D:\\3.txt", "rw");
            raf.seek(3);//指针到此位置
            raf.write("xy".getBytes());//覆盖此位置两个字符
        } catch (IOException e) {
        } finally {
            try {
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读写
    @Test
    public void test() {

        RandomAccessFile raf = null;
        RandomAccessFile raf1 = null;
        try {
            raf = new RandomAccessFile("D:\\1.txt", "rw");
            raf1 = new RandomAccessFile("D:\\2.txt", "rw");
            byte[] b = new byte[1024];
            int len;
            while ((len = raf.read(b)) != -1)
                raf1.write(b, 0, len);
        } catch (IOException e) {


        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
                if (raf != null)
                    raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        TestObjectStream tos = new TestObjectStream();
        tos.test1();

    }
}
