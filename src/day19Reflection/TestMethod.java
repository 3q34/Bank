package day19Reflection;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Created by cdx on 2019/7/19.
 * desc:获取方法
 */
public class TestMethod {
    private static final String TAG = "TestMethod";

    @Test
    public void test() {
        Class cl = Person.class;
        Method[] m = cl.getMethods();
        for (Method m1 : m) {
            System.out.println(m1);//包含父类中的方法，private default的不能得到,必须是public
        }
        Method[] m1 = cl.getDeclaredMethods();
        for (Method m2 : m1) {
            int i = m2.getModifiers();

            System.out.println(m2);//获取本身声明的所有方法
            System.out.println(Modifier.toString(i));//权限修饰符

            Class rt = m2.getReturnType();
            System.out.println(rt.getName());//返回值类型

            System.out.println( m2.getName());

          Class[] pr= m2.getParameterTypes();//参数

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
}
