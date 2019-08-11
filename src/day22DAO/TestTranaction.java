package day22DAO;

import day21JDBC.JDBCTools;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cdx on 2019/8/11.
 * desc:事务处理
 */
public class TestTranaction {
    private static final String TAG = "TestTranaction";

    @Test
    public void test() {
        Connection con = null;
        try {
            con = JDBCTools.getConnection();
            //开始事务，取消默认提交
            con.setAutoCommit(false);
            String sql = "update Student set age=age-5 where id=7";

            update(con, sql);
            // int i = 10 / 0;

            sql = "update Student set age=age+5 where id=8";

            update(con, sql);
            //提交事务:两个都处理完再提交，保证一致性
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JDBCTools.releaseDB(con, null, null);
        }


    }

    public static void update(Connection con, String sql, Object... args) {

        PreparedStatement ps = null;

        try {
            //获取SQL语句的statement对象

            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            boolean s = ps.execute();

            if (s) {
                System.out.println("数据更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCTools.releaseDB(null, ps, null);
        }
    }

    @Test
    public void testTranactionRead() {
        Connection con = JDBCTools.getConnection();
        String sql = "select * from student where id=8";
        getValue(con, sql);
        JDBCTools.releaseDB(con, null, null);
    }

    public static <E> E getValue(Connection con, String sql, Object... args) {
        E str = null;

        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //读已提交
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();

            while (resultSet.next()) {

                str = (E) resultSet.getObject(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return str;
        }
    }
}
