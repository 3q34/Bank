package day18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cdx on 2019/7/9.
 * desc:
 */
public class TestStringMethod {
    private static final String TAG = "TestStringMethod";

    public static void main(String[] args) {
        String str = "   asd  ";
        String st1 = myTrim(str);
        System.out.println(st1);

        String str2 = "asdfghasjkl";
        String st2 = myReverse(str2, 3, 6);
        System.out.println(st2);


        String str3 = "as";
        int st3 = myCount(str2, str3);
        System.out.println(st3);

        String st4 = getMaxSame("sfg", "asdfghasjkl");

        System.out.println(st4);


        List<String> st5 = getMaxSamelist("asfg", "asdfghasjkl");

        System.out.println(st5);

        System.out.println(mySort(str2));

    }

    @Test
    public void test() {
        String str = "asdfghjkl";
        String str1 = "asDfghjkl";
        char c = str.charAt(2);
        System.out.println(c);
        char[] c1 = str.toCharArray();
        System.out.println(c1);
        String[] str2 = str.split("d");
        System.out.println(Arrays.toString(str2));
        boolean b1 = str.startsWith("a");
        System.out.println(b1);
        boolean b2 = str.endsWith("s");
        System.out.println(b2);
        boolean b3 = str.equalsIgnoreCase(str1);
        System.out.println(b3);
    }

    @Test
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer("asdfghjkl");
        sb.append("123");//是在最h后面追加
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        sb.append(c, 0, c.length);
        System.out.println(sb);
        sb.reverse();//反转
        System.out.println(sb);
        int i = sb.capacity();
        System.out.println(i);
    }

    //去除空字符串
    public static String myTrim(String str) {
        return str.replace(" ", "");
    }

    //反转指定字符串
    public static String myReverse(String str, int indexs, int indexe) {
        StringBuffer st = new StringBuffer(str);
        StringBuffer st1 = new StringBuffer(st.substring(indexs, indexe));

        return new StringBuilder().append(
                st.substring(0, indexs))
                .append(st1.reverse()).append(st.substring(indexe, (str.length() - 1))).toString();


    }

    //包含字符串的次数
    public static int myCount(String st1, String st2) {
        String[] s = st1.split(st2);
        return s.length - 1;
    }

    //两个字符串最大相同字符串.有缺陷,可能存在相同长度的不同的字符串
    public static String getMaxSame(String str1, String str2) {
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() > str2.length()) ? str2 : str1;
        int len = minStr.length();

        String st = "";
        for (int i = len; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                st = minStr.substring(j, i);
                if (maxStr.contains(st)) {
                    return st;
                }
            }
        }
        return st;
    }

    //两个字符串最大相同字符串.相同长度的可以找出来
    public static List<String> getMaxSamelist(String str1, String str2) {
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() > str2.length()) ? str2 : str1;
        int len = minStr.length();

        List<String> st = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0, k = len - i; k <= len; j++, k++) {
                String st1 = minStr.substring(j, k);
                if (maxStr.contains(st1)) {
                    st.add(st1);

                }
            }
            if (st.size() != 0)
                break;
        }
        return st;
    }

    //对字符串中字符进行自然顺序排序
    public static String mySort(String str){
      char[] c= str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
