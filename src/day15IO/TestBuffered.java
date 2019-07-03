package day15IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/3.
 * desc:缓冲流
 */
public class TestBuffered {
    private static final String TAG = "TestBuffered";


    @Test
    public void test3() {
        String src = "D:\\1.txt";
        String dest = "D:\\5.txt";

        testBufferedReader(src, dest);
    }

    public void testBufferedReader(String src, String dest) {
        File file = new File(src);
        File file1 = new File(dest);
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter(file1);
            //节点流对象
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            String st;
            char[] b = new char[1024];
            int len;
            while ((len = br.read(b)) != -1) {
                bw.write(b, 0, len);
                bw.flush();
            }
//            while ((st = br.readLine()) != null) {
//                bw.write(st);
//                bw.newLine();
//                bw.flush();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭处理流，先关输出再关输入
                if (bw != null)
                    bw.close();
                if (br != null)
                    br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test() {
        long start = System.currentTimeMillis();
        String src = "D:\\1.png";
        String dest = "D:\\2.png";

        copyFile(src, dest);
        long end = System.currentTimeMillis();
        System.out.println("Buffered用时：" + (end - start));
    }

    @Test
    public void test1() {
        long start1 = System.currentTimeMillis();
        String src1 = "D:\\1.png";
        String dest1 = "D:\\4.png";

        copyFile1(src1, dest1);
        long end1 = System.currentTimeMillis();
        System.out.println("Stream用时：" + (end1 - start1));


    }

    /**
     * BufferedInputStream以及BufferedOutputStream缓冲流
     * 文本的用filereader和filewriter
     * 非文本的使用stream
     * 相较于FileInputStream和FileOuputStream是加速的，效率高了
     */

    public void copyFile(String src, String dest) {
        //缓冲流实现非文本文件的复制
        File file = new File(src);
        File file1 = new File(dest);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            //节点流对象
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭处理流，先关输出再关输入
                if (bos != null)
                    bos.close();
                if (bis != null)
                    bis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void copyFile1(String src, String dest) {
        //缓冲流实现非文本文件的复制
        File file = new File(src);
        File file1 = new File(dest);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭处理流，先关输出再关输入
                if (fos != null)
                    fos.close();
                if (fis != null)
                    fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
