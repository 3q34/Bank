package day21JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by cdx on 2019/8/7.
 * desc:
 */
public class TestStudent {
    private static final String TAG = "TestStudent";

    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println("请按照字段输入学生信息：");


        Scanner sc = new Scanner(System.in);
        System.out.println("name:");
        stu.name = sc.nextLine();
        System.out.println("age:");
        stu.age = sc.nextInt();
        System.out.println("address:");
        stu.address = sc.next();
        String sql = "insert into student (name,age,address ) values(?,?,?)";
        addstu(sql, stu.name, stu.age, stu.address);
        sc.close();
    }

    //可以进行占位符方式的sql语句拼接
    // 可以有效防止sql注入
    public static void addstu(String sql, Object... args) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCTools.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, null);
        }
    }
}
