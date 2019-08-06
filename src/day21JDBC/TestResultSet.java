package day21JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cdx on 2019/8/6.
 * desc:结果集ResultSet,调用executeQuery()方法，返回数据表
 */
public class TestResultSet {
    private static final String TAG = "TestResultSet";

    public static void main(String[] args) {
        test2();
    }

    @Test
    public void test() {
        String sql = "select * from student";
        List<Student> list = getInfo(sql);

        for (Student st : list) {
            System.out.println(st);
        }
    }

    //@Test
    public static void test2() {
        String name;
        int age;
        String address;
        System.out.println("请按照字段输入学生信息：");


        Scanner sc = new Scanner(System.in);
        System.out.println("name:");
        name = sc.nextLine();
        System.out.println("age:");
        age = sc.nextInt();
        System.out.println("adress:");
        address = sc.next();

        String sql = "insert into student (name,age,address) values('" + name + "'," + age + ",'" + address + "')";
         updateInfo(sql);
    }

    public static List<Student> getInfo(String sql) {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            TestDriverManager td = new TestDriverManager();
            con = td.getConnection();

            //获取SQL语句的statement对象

            statement = con.createStatement();

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student stu = new Student();
                //注意：resultSet的index不是从0开始，从1
                stu.id = resultSet.getInt(1);
                stu.name = resultSet.getString(2);
                stu.age = resultSet.getInt(3);
                stu.adress = resultSet.getString(4);
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return list;
        }

    }

    public static void updateInfo(String sql) {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        Statement statement = null;

        try {
            TestDriverManager td = new TestDriverManager();
            con = td.getConnection();

            //获取SQL语句的statement对象

            statement = con.createStatement();

            int s = statement.executeUpdate(sql);
            if(s>0) {
                System.out.println("新增数据成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }
}
