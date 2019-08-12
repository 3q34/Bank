package day22DAO;

import day21JDBC.JDBCTools;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by cdx on 2019/8/12.
 * desc:批处理
 */
public class TestBatch {
    private static final String TAG = "TestBatch";

    @Test
    public void testBatch() {
        long start=System.currentTimeMillis();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCTools.getConnection();
            JDBCTools.beginTx(con);
            String sql = "insert into student(name,age) values(?,?)";
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 100000; i++) {
                Date date = new Date(new Date().getTime());
                ps.setString(1, "name_" + i);
                ps.setInt(2, i);
            }
            JDBCTools.commit(con);
            long end=System.currentTimeMillis();
            System.out.println(end-start);
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCTools.roolback(con);
        } finally {
            JDBCTools.releaseDB(con, ps, null);
        }

    }

    @Test
    public void testBatch1() {
        long start=System.currentTimeMillis();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCTools.getConnection();
            JDBCTools.beginTx(con);
            String sql = "insert into student(name,age) values(?,?)";
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 100000; i++) {
                Date date = new Date(new Date().getTime());
                ps.setString(1, "name_" + i);
                ps.setInt(2, i);
                ps.addBatch();
                if ((i + 1) % 300 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            if (100000  % 300 != 0) {
                ps.executeBatch();
                ps.clearBatch();
            }
            JDBCTools.commit(con);
            long end=System.currentTimeMillis();
            System.out.println(end-start);
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCTools.roolback(con);
        } finally {
            JDBCTools.releaseDB(con, ps, null);
        }

    }
}
