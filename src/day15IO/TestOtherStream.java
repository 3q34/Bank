package day15IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/3.
 * desc:转换流：InputStreamReader OutputStreamWriter
 * 编码：字符串-->字符数组
 * 解码：字符数组-->字符串
 */
public class TestOtherStream {
    private static final String TAG = "TestOtherStream";

    @Test
    public void test() {
        File file = new File("D:1.txt");
        File file1 = new File("D:2.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            InputStreamReader isr = new InputStreamReader(fis, "GBK");//字节流，编码集
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
            br = new BufferedReader(isr);
            bw = new BufferedWriter(osw);
            String st;
            while ((st = br.readLine()) != null) {
                bw.write(st);
                bw.newLine();
                bw.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                br.close();
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
