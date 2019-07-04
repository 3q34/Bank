package day15IO.Exercise;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/4.
 * desc:
 */
public class TestExer {
    private static final String TAG = "TestExer";

    //非文本文件复制
    @Test
    public void test5() {
        BufferedInputStream br = null;
        BufferedOutputStream bw = null;
        try {
            br = new BufferedInputStream(new FileInputStream("D:\\情人劫.mp3"));
            bw = new BufferedOutputStream(new FileOutputStream("D:\\4情人劫.mp3"));

            byte[] b = new byte[1024];
            int len;
            while ((len = br.read(b)) !=-1) {
                bw.write(b,0,len);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            if (bw != null)
                bw.close();
            if (br != null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //文件复制
    @Test
    public void test4() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("D:\\1.txt"));
            bw = new BufferedWriter(new FileWriter("D:\\4.txt"));
            String st;
            while ((st = br.readLine()) != null) {
                bw.write(st);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        try {
            if (bw != null)
                bw.close();
            if (br != null)
                br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //使用字符流实现内容的读入
    @Test
    public void test3() {

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("D:\\3.txt"));
            String st;
            while ((st = bf.readLine()) != null) {
                System.out.print(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bf != null)
                    bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //字符流实现文本输出
    @Test
    public void test2() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("D:\\3.txt"));
            String st = "dwdadsadsf广泛大使馆反对广泛的发的四个地方";
            bw.write(st);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    //字节流实现输出
    @Test
    public void test() {
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream("D:\\2.txt"));
            String st = "还傻傻上帝会发动i富含淀粉的发货单覅的";
            bos.write(st.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
