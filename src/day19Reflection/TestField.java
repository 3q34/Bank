package day19Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by cdx on 2019/7/18.
 * desc:获取运行时类的属性
 */
public class TestField {
    private static final String TAG = "TestField";

    @Test
    public void test() {

        Class cl = Person.class;
        Field[] f = cl.getFields();
        for (int i = 0; i < f.length; i++)
            System.out.println(f[i]);//只能得到运行时类中声明为public的属性
        //若要获取所有属性
        System.out.println("haha");
        Field[] f1 = cl.getDeclaredFields();
        for (Field fi : f1) {
            System.out.println(fi);

        }
    }

    //获取修饰符
    //各部分的内容
    @Test
    public void test2() {
        Class cl = Person.class;
        Field[] f = cl.getDeclaredFields();
        for (Field fi : f) {
            int i = fi.getModifiers();
            System.out.println(Modifier.toString(i));
        }
    }
}
