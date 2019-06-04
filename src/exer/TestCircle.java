package exer;

import day09.Circle;

/**
 * Created by cdx on 2019/1/17.
 * desc:
 */
public class TestCircle {
    public static void main(String[] args) {
        Circle c1=new Circle(2.3);
        Circle c2=new Circle(2.3);
        System.out.println(c1.equals(c2));
       int s= Integer.parseInt("11");
       String d=String.valueOf(s);
        System.out.println(d);
    }
    private static final String TAG = "TestCircle";

}
