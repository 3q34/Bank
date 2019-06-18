package TestList;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cdx on 2019/6/18.
 * desc:
 */
public class TestSet {
    private static final String TAG = "TestSet";

    //存储无序，不可重复的元素
    @Test
    public void testSet1() {
        Set set = new HashSet();//主要实现类
        set.add(1);
        set.add("AA");
        set.add(null);
        System.out.println(set.size());
        System.out.println(set);//无序性，不等于随机性
        Person p1 = new Person("zhangsan1", 20);
        set.add(p1);
        set.add(new Person("zhangsan", 20));//如果不重写string方法，只返回指针
        set.add(new Person("zhangsan", 20));//如果不重写hashcode，元素会有重复
        System.out.println(set.size());
        System.out.println(set);
    }
}
