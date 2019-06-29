package day14.TestList.ExerTreeSet;

import org.junit.Test;


import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by cdx on 2019/6/20.
 * desc:
 */
public class TestEmployee {
    private static final String TAG = "TestEmployee";

    @Test
    public void test2() {
        Comparator cm = new Comparator() {
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
        TreeSet set = new TreeSet(cm);
        Employee1 em1 = new Employee1("刘德华", 53, new MyDate(1965, 2,10 ));
        Employee1 em2 = new Employee1("郭富城", 35, new MyDate(1965, 2, 6));
        Employee1 em3 = new Employee1("张学友", 51, new MyDate(1945, 2, 5));
        Employee1 em4 = new Employee1("黎明", 76, new MyDate(1967, 2,7 ));
        Employee1 em5 = new Employee1("张三", 20, new MyDate(1985, 2, 9));
        set.add(em1);
        set.add(em2);
        set.add(em3);
        set.add(em4);
        set.add(em5);
        System.out.println(set.size());
        Iterator i = set.iterator();
        while (i.hasNext())
            System.out.println(i.next());

    }

    @Test
    public void test1() {
        Employee em1 = new Employee("刘德华", 53, new MyDate(10, 2, 1965));
        Employee em2 = new Employee("郭富城", 35, new MyDate(6, 2, 1963));
        Employee em3 = new Employee("张学友", 51, new MyDate(5, 2, 1945));
        Employee em4 = new Employee("黎明", 76, new MyDate(7, 2, 1967));
        Employee em5 = new Employee("张三", 20, new MyDate(9, 2, 1985));
        Employee em6 = new Employee("张三", 20, new MyDate(9, 2, 1985));
        TreeSet set = new TreeSet();
        set.add(em1);
        set.add(em2);
        set.add(em3);
        set.add(em4);
        set.add(em5);
        set.add(em6);
        System.out.println(set.size());
        Iterator i = set.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
