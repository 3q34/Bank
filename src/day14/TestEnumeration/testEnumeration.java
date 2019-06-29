package day14.TestEnumeration;

import org.junit.Test;

import java.util.Enumeration;
import java.util.StringTokenizer;

/**
 * Created by cdx on 2019/6/23.
 * desc:
 */
public class testEnumeration {
    private static final String TAG = "testEnumeration";

    //是迭代器Iterator的旧版本
    @Test
    public void test() {
        Enumeration enumeration = new StringTokenizer("ab-c-df-g", "-");
        while (enumeration.hasMoreElements())
            System.out.println(enumeration.nextElement());
    }
}

