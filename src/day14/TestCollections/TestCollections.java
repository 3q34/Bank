package day14.TestCollections;

import org.junit.Test;

import java.util.*;

/**
 * Created by cdx on 2019/6/23.
 * desc:
 * <p>
 */
public class TestCollections {
    private static final String TAG = "day14/TestCollections";

    /*synchronized方法，
     *可使集合包装成线程同步的集合，
     *解决多线程并发访问集合时线程安全问题
     * */
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(123);
        list.add(22);
        list.add(45);
        list.add(45);
        Collections.synchronizedList(list);

    }

    /*
     * max()
     * min()
     * frequency(Collection,Object)指定元素出现的频率
     *copy(List Dest.List src);复制
     * replaceAll(List list,Object oldvalue,Object newvalue)
     * */
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(22);
        list.add(45);
        list.add(45);
        System.out.println(list);
        Object o = Collections.max(list);
        System.out.println(o);
        Object o1 = Collections.frequency(list, 45);
        System.out.println(o1);
        //List l1=new ArrayList();//错误的实现方式。越界报错
        /*
         * 浅谈Arrays.asList()方法的使用
         *首先，该方法是将数组转化为list。有以下几点需要注意：

         *　（1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）

         *（2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新

         *（3）不支持add和remove方法*/
        List l1 = Arrays.asList(new Object[list.size()]);
        Collections.copy(l1, list);
        System.out.println(l1);
    }

    /*操作Collection以及map的工具类：Collections
     * <p>
     * 区分二者的区别
     * reverse(List)反转顺序
     * shuffle(List)随机排序
     * sort(List,Comparator):根据指定的Comparator产生的顺序对List排序
     * swap（List，int i,int j):将i 互换
     * */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(22);
        list.add(45);
        System.out.println(list);
        // Collections collections=new Collections();//一般类的使用是首先创建类的对象。
        // 但是工具类中一般都是静态方法，可以直接调用
        Collections.reverse(list);//反转
        //System.out.println(list);
        Collections.shuffle(list);//随机排序
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);//默认从小到大排序
        Collections.swap(list, 0, 2);
        System.out.println(list);//交换位置
    }
}
