package exer.TestCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


/**
 * Created by cdx on 2019/6/17.
 * desc:
 */
public class TestCollection {
    private static final String TAG = "TestCollection";

    public static void main(String[] args) {

        testCollection2();
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
