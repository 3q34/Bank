package day21JDBC;

import org.junit.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by cdx on 2019/8/6.
 * desc:获取连接后通过Statement进行insert update等操作
 */
public class TestStatement {
    private static final String TAG = "TestStatement";

    @Test
    public void test() {
        String sqladd = "insert into student (name,age,address) values('刘德华',56,'香港')";
        String sqlupd = "update student set name='梁朝伟' where id=4";
        String sqldel = "delete student where name='刘德华'";
        sqlUpdate(sqlupd);
    }

    public void sqlUpdate(String sql) {
        Connection con = null;
        Statement statement = null;
        try {
            TestDriverManager td = new TestDriverManager();
            con = td.getConnection();

            //获取SQL语句的statement对象

            statement = con.createStatement();

            int s = statement.executeUpdate(sql);
            if (s > 0)
                System.out.println("操作成功");
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
