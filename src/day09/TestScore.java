package day09;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by cdx on 2019/1/17.
 * desc:
 */
public class TestScore {
    private static final String TAG = "TestScore";

    public static void main(String[] args) {
        Vector v = new Vector();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩，负数结束");
        int maxscore = 0;
        for (; ; ) {
            int s1 = scanner.nextInt();
            if (s1 < 0) {
                break;
            }
            if (maxscore < s1)
                maxscore = s1;

            v.addElement(s1);
        }
        for (int i = 0; i < v.size(); i++) {
            int score = Integer.parseInt(v.elementAt(i).toString());

            if (maxscore - score <= 10) {
                System.out.println("A");
            }
            if (maxscore - score <= 20) {
                System.out.println("B");
            } else
                System.out.println("C");

            System.out.println(v.elementAt(i));
        }

    }
}
