package TestGeneric;

import org.junit.Test;

import java.util.*;

/**
 * Created by cdx on 2019/6/26.
 * desc:
 * 解决存储安全性问题；解决获取数据元素时，需要类型强转的问题
 */
public class TestGeneric {
    private static final String TAG = "TestGeneric";

    //自定义泛型类
    @Test
    public void test3() {
        Order<String> order = new Order<String>();
        order.setT("哈哈");
        System.out.println(order.getT());
        order.add();
        List<String> list = order.list;
        System.out.println(list);
        SubOrder<Integer> inorder=new SubOrder<Integer>();
        inorder.setT(112);
        System.out.println(inorder.getT());
    }

    @Test
    public void test2() {
        Map<String, Book> map = new HashMap<>();
        Book book = new Book("三生三世", 1);
        Book book1 = new Book("三重门", 2);
        map.put("haha", book);
        map.put("hehe", book1);
        Set<Map.Entry<String, Book>> set = map.entrySet();
        for (Map.Entry<String, Book> m : set) {
            System.out.println(m.getValue());
        }

    }

    @Test
    public void testGeneric() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("哈哈");
        list.add(0, "哈哈哈");
        System.out.println(list);
        List<Book> list1 = new ArrayList<Book>();//<>尖括号指的E implents Collection
        Book book = new Book("三生三世", 1);
        Book book1 = new Book("三重门", 2);
        list1.add(book);
        list1.add(book1);
        System.out.println(list1);
    }

}
