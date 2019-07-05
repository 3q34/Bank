package day15IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/4.
 * desc:数据处理流
 * 用来处理基本数据类型、string、字节数组的数据
 * DataInputStream DataOutputStream
 */
public class TestDataStream {
    private static final String TAG = "TestDataStream";

    @Test
    public void test1() {
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {

            fis = new FileInputStream("D:\\1.txt");
            dis = new DataInputStream(fis);
            int len = dis.readInt();
            System.out.println(len );

            float f = dis.readFloat();
            System.out.println( f);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //输出
    @Test
    public void test() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("D:1.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("哈哈哈哈哈哈");
            dos.write(123);
            dos.writeDouble(10.2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
