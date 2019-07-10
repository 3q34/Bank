package day18;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cdx on 2019/7/10.
 * desc:与时间相关的类
 * Date和 java.sql.Date
 * SimpleDateFormat
 * Calendar
 */
public class TestDateToString {
    private static final String TAG = "TestDateToString";

    @Test
    public void test1() {
        Date d1 = new Date();
        System.out.println(d1.toString());
        System.out.println(d1.getTime());
        java.sql.Date d2 = new java.sql.Date(1234567123L);
        System.out.println(d2);

        //Date类的API不易于国际化，大部分都废弃了
        //Java.text.SimpleDateFormat类，
        // 是一个不与语言环境有关的方式来格式化和解析日期的具体类
    }

    @Test
    public void test2() {

        SimpleDateFormat sdf = new SimpleDateFormat();
        String str = sdf.format(new Date());//19-7-10 下午3:55 默认模式
        System.out.println(str);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//2019-02-10 04:02:17  2019-03-10 16:03:00
        String st = sdf1.format(new Date());
        System.out.println(st);


        try {
            Date d1 = sdf.parse("19-7-10 下午3:55");//默认的格式才能转换回去
            //不是所有的格式都可以解析
            System.out.println(d1);

            Date d2 = sdf1.parse("2019-03-10 16:03:00");//参数的格式
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
