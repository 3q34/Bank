package TestList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by cdx on 2019/6/18.
 * desc:
 */
public class TestList {
    private static final String TAG = "TestList";

    public static void main(String[] args) {
        testList1();
    }

    //ArrayList
    //新增方法，可在index位置add 或remove .etc
    public static void testList1() {

       // List list = new ArrayList();
        LinkedList list =new LinkedList();
        list.add(1);
        list.add(2);
        list.add(0, 5);
        System.out.println(list);
        Object ob = list.get(1);
        System.out.println(ob);
        List list1 = new ArrayList();
        list1.add(0);
        list1.add(8);
        list.add(2, list1);//在指定位置添加数组，不是将数组的元素放在数组中，而是新增的数组为一个整体
        System.out.println(list);

       // list.remove(2);
        System.out.println(list);
        list.set(0, 888);
        System.out.println(list);
        System.out.println(list.indexOf(1));//返回元素位置
        List list2 = list.subList(0, 3);//0-3左闭右开
        System.out.println(list2);

    }
}
