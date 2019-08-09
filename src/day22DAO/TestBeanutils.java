package day22DAO;

import day21JDBC.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by cdx on 2019/8/9.
 * desc:验证beanutils的方法，注意：需要logging包
 */
public class TestBeanutils {
    private static final String TAG = "TestBeanutils";

    @Test
    public void testSetProperty() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object object = new Student();

        System.out.println(object);
        BeanUtils.setProperty(object, "id", 10);
        System.out.println(object);
        String isss = BeanUtils.getProperty(object, "id");
        System.out.println(isss);
    }
}
