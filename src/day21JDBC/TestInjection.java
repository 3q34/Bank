package day21JDBC;

import org.junit.Test;

import java.sql.*;

/**
 * Created by cdx on 2019/8/7.
 * desc:SQL注入
 */
public class TestInjection {
    private static final String TAG = "TestInjection";

    @Test
    public void test() {
        String name = "a' or password= ";
        String password = "  or '1' ='1";
        String sql = "select * from student where name='" + name + "' and password='" + password + "'";
        System.out.println(sql);
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = JDBCTools.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next())
                System.out.println("查询成功");
            else System.out.println("查询失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, statement, rs);
        }
    }

    //如果使用PreparedStatement,不会出现注入
    @Test
    public void test2() {
        String name = "a' or password= ";
        String password = "  or '1' ='1";
        String sql = "select * from student where name=? and password=?";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            con = JDBCTools.getConnection();
            statement = con.prepareStatement(sql);
            statement.setObject(1, name);
            statement.setObject(2, password);
            rs = statement.executeQuery();
            if (rs.next())
                System.out.println("登录成功");
            else System.out.println("不匹配或不存在");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, statement, rs);
        }
    }
}
