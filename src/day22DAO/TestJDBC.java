package day22DAO;

import day21JDBC.JDBCTools;
import org.junit.Test;

import java.sql.*;

/**
 * Created by cdx on 2019/8/10.
 * desc:
 */
public class TestJDBC {
    private static final String TAG = "TestJDBC";

    //获取插入数据的主键值
    @Test
    public void test() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            con = JDBCTools.getConnection();
            String sql = "insert into student (name,age,address,password) values(?,?,?,?)";
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, "周星驰");
            ps.setObject(2, 67);
            ps.setObject(3, "HK");
            ps.setObject(4, "!QAZ2wsx");
            ps.executeUpdate();
            resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
              Object obj=  resultSet.getObject(1);
                System.out.println(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }

    }
}
