package day19Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cdx on 2019/7/18.
 * desc:
 */
public class TestConstructor {
    private static final String TAG = "TestConstructor";

    @Test
    public void test() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //要有空参构造器
        String classname = "day19Reflection.Person";
        Class clazz = Class.forName(classname);
        Person p = (Person) clazz.newInstance();

        Field f1 = clazz.getField("name");
        f1.set(p, "cdx");
        Field f2 = clazz.getField("age");
        f2.set(p, 23);
        System.out.println(p);

        Method m1 = clazz.getMethod("show");
        m1.invoke(p);

        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(p, "CHN");


    }

    //调用指定的构造器
    @Test
    public void test2() throws Exception {
        String className = "day19Reflection.Person";
        Class clazz = Class.forName(className);
        Constructor cons = clazz.getDeclaredConstructor(String.class, int.class);
        cons.setAccessible(true);

        Person p=(Person) cons.newInstance("陈东晓",29);
        System.out.println(p);

    }
}
