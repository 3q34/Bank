package day19Reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by cdx on 2019/7/10.
 * desc:反射，动态语言
 * Class是反射的源头
 */
public class TestReflection {
    private static final String TAG = "TestReflection";

    //加载器
    @Test
    public void test5() throws ClassNotFoundException, IOException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader);
        Class clazz = Person.class;
        ClassLoader loder1 = clazz.getClassLoader();//自定义类是由系统加载器加载的
        System.out.println(loder1);

        String name = "java.lang.Object";
        Class clazz1 = Class.forName(name);
        ClassLoader loader2 = clazz1.getClassLoader();
        System.out.println(loader2);

        //有了ClassLoder之后，可以做什么
        //系统加载配置文件
        InputStream is = loader.getResourceAsStream("day19Reflection\\jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        System.out.println(user);
        String password = pros.getProperty("password");
        System.out.println(password);
    }


    //获取Class的实例
    @Test
    public void test4() throws ClassNotFoundException {
        //1、调用运行时类的本身的.class属性
        Class<Person> cl = Person.class;
        cl.getName();

        //2、通过运行时类的对象获取
        Person p = new Person();
        Class cl3 = p.getClass();
        cl3.getName();

        //3、通过Class的静态方法获取
        String classname = "Person";
        Class cl4 = Class.forName(classname);

        //4、通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class cl5 = classLoader.loadClass(classname);
    }

    @Test
    public void test3() {
        Person p = new Person();
        Class clazz = p.getClass();//通过运行时类的对象，调用getClass方法，返回其运行时类

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());//父类：Object


    }

    //使用反射创建对象
    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> cs = Person.class;
        Person p = cs.newInstance();
        System.out.println(p);

        Field fi = cs.getField("name");//属性必须是public修饰符
        fi.set(p, "刘德华");
        Field f2 = cs.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p, 12);
        System.out.println(p);
        Method method = cs.getMethod("display", String.class);
        method.invoke(p, "cn");
    }

    //不使用反射创建类的对象
    @Test
    public void test2() {
        Person p1 = new Person("haah");
        p1.setName("cdx");
        p1.setAge(12);
        p1.show();
        p1.display("china");
    }
}
