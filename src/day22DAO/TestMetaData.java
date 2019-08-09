package day22DAO;

import day21JDBC.JDBCTools;
import org.junit.Test;

import java.sql.*;

/**
 * Created by cdx on 2019/8/9.
 * desc:描述数据库的元数据对象,获取数据库相关信息
 */
public class TestMetaData {
    private static final String TAG = "TestMetaData";

    @Test
    public void testDatabaseMetaData() {
        Connection con = null;
        DatabaseMetaData dbmd = null;
        ResultSet resultSet = null;
        try {
            con = JDBCTools.getConnection();
            dbmd = con.getMetaData();
            //版本号
            int version = dbmd.getDatabaseMajorVersion();
            System.out.println(version);
            //mysql用户名
            String user = dbmd.getUserName();
            //包含的数据库
            resultSet = dbmd.getCatalogs();
            while (resultSet.next())
                System.out.println(resultSet.getString(1));
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, null, resultSet);
        }
    }

    @Test
    public void testResultSetMetaData() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd=null;
        String sql = "select * from student where id=?";
        try {
            con = JDBCTools.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, 9);
            resultSet = ps.executeQuery();
            rsmd=resultSet.getMetaData();
          int count=  rsmd.getColumnCount();
         for(int i= 0; i < count; i++) {
           String columnName=rsmd.getColumnName(i+1);
           String columnLabel=rsmd.getColumnLabel(i+1);
             System.out.println(columnLabel+" "+columnName);
         }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }
    }
}
