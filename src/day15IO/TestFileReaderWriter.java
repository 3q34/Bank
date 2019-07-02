package day15IO;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by cdx on 2019/7/2.
 * desc:仅支持文本文件的操作
 */
public class TestFileReaderWriter {
    private static final String TAG = "TestFileReaderWriter";

    @Test
    public void test() throws IOException {
        File file = new File("D:\\1.txt");
        FileReader fileReader = new FileReader(file);
        char[] c = new char[20];
        int len;
        while ((len = fileReader.read(c)) != -1) {
            for (char ch : c) {
                System.out.print(ch);
            }
        }
        fileReader.close();
    }

    @Test
    public void test2() throws IOException {
        File file = new File("D:\\1.txt");
        FileWriter fw = new FileWriter(file);
        //char[] c=new String("I love u").toCharArray();
        String c = "I love U";
        fw.write(c);
        fw.close();

    }
}
