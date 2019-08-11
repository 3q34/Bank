package day22DAO;

import day21JDBC.JDBCTools;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * Created by cdx on 2019/8/10.
 * desc:
 */
public class TestJDBC {
    private static final String TAG = "TestJDBC";

    //获取插入数据的主键值
    @Test
    public void testGeneratedKeys() {
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
                Object obj = resultSet.getObject(1);
                System.out.println(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }

    }

    //插入大对象数据BLOB类型
    @Test
    public void testBLOB() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream is = null;

        try {
            con = JDBCTools.getConnection();
            is = new FileInputStream(new File("D://1.png"));
            String sql = "insert into student1 (name,age,address,password,photo) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setObject(1, "周星驰");
            ps.setObject(2, 67);
            ps.setObject(3, "HK");
            ps.setObject(4, "!QAZ2wsx");
            ps.setBlob(5, is);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }

    }

    //插入大对象数据BLOB类型
    @Test
    public void testReadBLOB() {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream is = null;
        OutputStream os=null;
        try {
            con = JDBCTools.getConnection();
            is = new FileInputStream(new File("D://1.png"));
            String sql = "select * from student1 where id=?";
            ps = con.prepareStatement(sql);
            ps.setObject(1, 1);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Blob photo = resultSet.getBlob(6);
                is = photo.getBinaryStream();
            }
            os = new FileOutputStream(new File("D://3.png"));
            int len;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            os.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }

    }
}
