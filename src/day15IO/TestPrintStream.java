package day15IO;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by cdx on 2019/7/4.
 * desc:
 */
public class TestPrintStream {
    private static final String TAG = "TestPrintStream";

    //输出到文件
    @Test
    public void test() {
        PrintStream ps = null;
        try {
            ps = new PrintStream(new File("D:1.txt"));
            System.setOut(ps);
            //ps.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
        }
    }
}
