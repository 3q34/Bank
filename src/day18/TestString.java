package day18;

import org.junit.Test;

/**
 * Created by cdx on 2019/7/8.
 * desc:
 */
public class TestString {
    private static final String TAG = "TestString";

    @Test
    public void test() {
        String str1 = "JavaEE";
        String str2 = "JavaEE";
        String str3 = new String("JavaEE");
        String str4 = "JavaEE" + "Android";
        String str5 = "Android";
        String str6 = str1 + str5;
        str5 = str5 + "Handoop";
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//false
        System.out.println(str1.equals(str3));//true
        System.out.println(str4 == str6);//false
        System.out.println(str4.equals(str6));//true

    }
}
