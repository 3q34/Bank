package exer.Employee;

import java.util.Scanner;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public class PayrollSystem {
    private static final String TAG = "PayrollSystem";

    public static void main(String[] args) {
        Employee[] emps = new Employee[3];
        emps[0] = new SalariedEmployee(10000, "李磊", 1, new Mydate(11, 22, 1988));
        emps[1] = new HourlyEmployee(100, 8, "张三", 2, new Mydate(12, 22, 1987));
        emps[2] = new SalariedEmployee(30000, "李四", 3, new Mydate(10, 22, 1989));
        Scanner sc = new Scanner(System.in);
        System.out.println("输入本月月份");
        int month = sc.nextInt();
        for (int i = 0; i <= 2; i++) {
            if (emps[i].getBirthday().getMonth() == month) {
                System.out.println("加工资200");
                System.out.println(emps[i].earnings() + 200);
            } else
                System.out.println(emps[i].earnings());

        }

    }
}
