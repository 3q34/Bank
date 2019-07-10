package day18;

import org.junit.Test;

/**
 * Created by cdx on 2019/7/10.
 * desc：字符类与基本数据类型和包装类之间的转换
 */
public class TestStringToOtherClass {
    private static final String TAG = "TestStringToOtherClass";

    @Test
    public void test5() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        String str2 = i + "";
        str2 = String.valueOf(i);
        //字符串与字节数组转换
        byte[] b = str2.getBytes();
        for (byte by : b
        ) {
            System.out.println((char) by);
        }
        System.out.println(new String(b));

        //字符串与字符数组之间的转换
        String str3 = "13244asdf中国";
        char[] c = str3.toCharArray();
        for (char c1 : c
        ) {
            System.out.println(c1);
        }
        System.out.println(c);

    }

    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer();//可变的字符序列
        sb.append("asd").append(123);
        sb.reverse();
        System.out.println(sb);
        int i = sb.capacity();
        System.out.println(i);
        // ArrayList list = new ArrayList();
        sb.insert(3, "qwe");
        System.out.println(sb);
        sb.delete(0, 2);//前闭后开
        System.out.println(sb);
        char[] c=new String("1qwsdv").toCharArray();
        for (char c1:c
             ) {

        }
        sb.append(c);
        sb.setCharAt(0, (char) 1 );
        System.out.println(sb);
    }
}
