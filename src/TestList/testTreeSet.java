package TestList;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cdx on 2019/6/19.
 * desc:
 */

public class testTreeSet {
    private static final String TAG = "testTreeSet";

    @Test
    public void testTreeSet1() {
        Set set = new TreeSet();
        //Set中元素必须是同一个类型
        //String中重写了compareTo方法，因此Person类中也要重写此方法
        // set.add(1);
        set.add("AA");
        set.add("哈哈");//自然排序

        //set.add(new Person("hah", 30));
        //set.add(new Person("hah1", 30));
        //set.add(new Person("ahah", 30));//按照名字排序
        for (Object o : set) System.out.println(o);

    }
}
