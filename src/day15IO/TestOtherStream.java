package day15IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/3.
 * desc:转换流：InputStreamReader OutputStreamWriter
 * 编码：字符串-->字符数组
 * 解码：字符数组-->字符串
 * <p>
 * 标准的输入输出流的使用：System.out System.in 属于printstream
 */
public class TestOtherStream {
    private static final String TAG = "TestOtherStream";

    public static void main(String[] args) {
        test4();
    }

    //标准的输入输出流的使用：System.out System.in
    //@Test//无法在Junit Test中运行，至少Idea是这样，但是可以在
    public static void test4() {
        BufferedReader br = null;
        try {
            InputStream inputStream = System.in;
            InputStreamReader isr = new InputStreamReader(inputStream);
            br = new BufferedReader(isr);
            String st;
            while (true) {
                System.out.println(" 请输入字符串：");
                st = br.readLine();
                if (st.equalsIgnoreCase("e") || st.equalsIgnoreCase("exit")) {
                    break;
                }
                String str = st.toUpperCase();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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
