package day15IO.Exercise;

import java.util.Scanner;

/**
 * Created by cdx on 2019/7/5.
 * desc:
 */
public class MyInput {
    private static final String TAG = "MyInput";

    public static void main(String[] args) {
        MyInput mi=new MyInput();
        System.out.println("请输入字符：");
        System.out.println(mi.nextString()) ;
        System.out.println(mi.nextBoolean()) ;
        System.out.println(mi.nextInt()) ;
    }
    public String nextString() {

        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public int nextInt() {
        System.out.println("请输入数字：");
        return Integer.parseInt(nextString());
    }

    public boolean nextBoolean() {
        System.out.println("请输入Boolean类型的值：");
        return Boolean.parseBoolean(nextString());
    }
}

