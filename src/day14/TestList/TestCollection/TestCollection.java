package day14.TestList.TestCollection;

import java.util.*;


/**
 * Created by cdx on 2019/6/17.
 * desc:
 */
public class TestCollection {
    private static final String TAG = "TestCollection";

    public static void main(String[] args) {

        testCollection2();
    }

    //增强for循环就是foreach
    public void testBianli2() {

        Collection coll = new ArrayList();
        //size
        System.out.println(coll.size());
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        Collection coll1 = Arrays.asList(1, 2, 3);
        coll.addAll(coll1);
        for (Object b : coll) {
            System.out.println(b);
        }

    }


    //集合遍历迭代器实现

    public void testBinli() {
        Collection coll = new ArrayList();
        //size
        System.out.println(coll.size());
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        Collection coll1 = Arrays.asList(1, 2, 3);
        coll.addAll(coll1);
        Iterator i = coll.iterator();
        while ((i.next() != null)) {
            System.out.println(i.next());
        }
    }

    public static void testCollection2() {
        Collection coll = new ArrayList();
        //size
        System.out.println(coll.size());
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        Collection coll1 = Arrays.asList(1, 2, 3);
        coll.addAll(coll1);
        System.out.println(coll);
        //contains()

        boolean b = coll.contains(123);
        System.out.println(b);
        coll.add(new Person("haha", 23));
        boolean b2 = coll.contains(new Person("haha", 23));

        System.out.println(b2);
        //retainAll保留集合相同的元素，交集
        coll.retainAll(coll1);
        //delete
        coll.remove(1);
        //差集，去除共有的元素
        coll.removeAll(coll1);
        //hashCode()计算hash值，决定堆空间的区域
        coll.hashCode();
        //toArray()将集合转化成数组
        Object[] obj = coll.toArray();
    }

    public void testCollection1() {
        Collection coll = new ArrayList();
        //size
        System.out.println(coll.size());
        coll.add(123);
        coll.add("AA");
        coll.add(new Date());
        Collection coll1 = Arrays.asList(1, 2, 3);
        coll.addAll(coll1);
        System.out.println(coll);
        //isempty
        coll.isEmpty();
        coll.clear();


        System.out.println(coll);
    }
}
