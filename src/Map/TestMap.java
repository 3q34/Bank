package Map;

import TestList.ExerTreeSet.Employee1;
import TestList.ExerTreeSet.MyDate;
import org.junit.Test;

import java.util.*;

/**
 * Created by cdx on 2019/6/21.
 * desc:
 */
public class TestMap {
    private static final String TAG = "TestMap";
//定制排序
    @Test
    public void test5(){
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee1 && o2 instanceof Employee1) {
                    Employee1 e1 = (Employee1) o1;
                    Employee1 e2 = (Employee1) o2;
                    MyDate birth1 = e1.getBirthday();
                    MyDate birth2 = e2.getBirthday();
                    if (birth1.getYear() != birth2.getYear())
                        return birth1.getYear() - birth2.getYear();
                    else {
                        if (birth1.getMonth() != birth2.getMonth())
                            return birth1.getMonth() - birth2.getMonth();
                        else
                            return birth1.getDay() - birth2.getDay();

                    }

                }
                return 0;
            }
        };

        TreeMap m = new TreeMap(com);
        m.put(new Person("zhangsan1", 10), 222);
        m.put(new Person("zhangsan", 10), 222);

        m.put(new Person("zhangsan2", 10), 222);
        System.out.println(m);

    }

    //TreeMap  按照添加进Map中属性的key进行排序,那么key必须是同一类型的对象,自然排序
    @Test
    public void test4() {
        Map m = new TreeMap();
        //m.put(1,2);
        m.put(new Person("zhangsan1", 10), 222);
        m.put(new Person("zhangsan", 10), 222);

        m.put(new Person("zhangsan2", 10), 222);
        System.out.println(m.size());
        Set s = m.keySet();
        Iterator i = s.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }

    //linkedHashmap
    @Test
    public void test3() {
        Map m = new LinkedHashMap();
        m.put(1, 2);
        m.put("哈哈", 21);
        Set set = m.keySet();
        System.out.println(set);//打印key
        Set s = m.entrySet();
        Iterator i = s.iterator();

        while (i.hasNext())
            System.out.println(i.next());

        for (Object o : s) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "##" + entry.getValue());
        }


    }

    //map的遍历
    @Test
    public void test2() {
        Map m = new HashMap();
        m.put(1, 22);
        m.put("哈哈", 21);
        m.put(null, null);

        //遍历key集(key是按照set存放的)
        Set s = m.keySet();
        Iterator i = s.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        //如何遍历value
        Collection c = m.values();
        Iterator i1 = c.iterator();
        while (i1.hasNext()) System.out.println(i1.next());
        //如何遍历kty-value
        Set s1 = m.entrySet();
        //方法一
        Iterator i2 = s1.iterator();
        while (i2.hasNext()) System.out.println(i2.next());
        //方法二

        for (Object o : s1) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "@" + entry.getValue());
        }


    }

    //保存具有映射关系的key
    //实验分支提交和合并
    @Test
    public void test() {
        Map m = new HashMap();
        m.put(1, 22);
        m.put("哈哈", 21);
        m.put(null, null);
        Map m1 = new HashMap();
        m1.put(11, 22);
        m1.put("哈哈1", 21);
        m1.put(null, null);
        m.putAll(m1);
        Object o = m.get(1);
        m.put(new Person("zhangsan", 10), 222);
        m.put(222, new Person("zhangsan", 10));//equal若不重写，他俩都会加入到map中，重写后则只有一个
        m.remove(222);
        System.out.println(m.size());
        System.out.println(m);


    }


}
