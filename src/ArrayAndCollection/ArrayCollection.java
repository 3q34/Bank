package ArrayAndCollection;

import org.junit.Test;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cdx on 2019/6/24.
 * desc:
 */
public class ArrayCollection {
    private static final String TAG = "ArrayCollection";
    /*
     * 数组和集合的区别
     *
     * */

    @Test
    public void test() {
        //数组
        int[] a = {1, 2, 3, 4, 5};//以为数组
        int[] arr = {12, 3, 4, 8, 5, 6, 6, 7, 8, 8, 9, 8};
        int[] arr1 = new int[]{12, 3, 4, 8, 5, 6, 6, 4};
        int[][] temp = new int[][]
                {
                        {1, 2}, {3, 4}
                };


        //集合
        //List Set Map

    }

    @Test

    public void test1() {
        //自然排序
        Person person = new Person("aa", 1);
        Person person1 = new Person("bb", 1);
        Person person2 = new Person("cc", 1);
        Set set = new TreeSet();

        set.add(person);
        set.add(person1);
        set.add(person2);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());

        // //自制排序
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person1 && o2 instanceof Person1) {
                    Person1 p = (Person1) o1;
                    Person1 p1 = (Person1) o2;
                    if (p.getAge() != p1.getAge())
                        return p.getAge() - p1.getAge();
                    else return p.getName().compareTo(p1.getName());
                }
                return 0;
            }
        };
        Set set1 = new TreeSet(comparator);
        Person1 p1 = new Person1("aa", 14);
        Person1 p2 = new Person1("bb", 10);
        Person1 p3 = new Person1("cc", 10);
        set1.add(p1);
        set1.add(p2);
        set1.add(p3);
        System.out.println(set1);

    }
}
