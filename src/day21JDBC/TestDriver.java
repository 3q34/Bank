package day21JDBC;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by cdx on 2019/8/4.
 * desc:获取数据库连接的方法，Driver
 */
public class TestDriver {
    private static final String TAG = "TestDriver";

    @Test
    public void test() throws Exception {
//        JDBCType jdbcType=new JDBCType();
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
//        ClassLoader classLoader = Properties.class.getClassLoader();
//        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
//        info.load(is);
        info.put("user", "root");
        info.put("password", "root");

        Connection connection = driver.connect(url, info);

        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test1() {
        Connection con = getConnection();
        System.out.println(con);
        if (con != null)
            try {

                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    /**
     * Created by cdx on 2019/8/5.
     * desc:通过配置文件获取jdbc属性
     * 反射
     */
    public Connection getConnection() {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;
        Connection connection = null;
        try {
            Properties properties = new Properties();

            InputStream is = this.getClass().getResourceAsStream("jdbc.properties");
            properties.load(is);
            driverClass = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            //具体开发不使用Driver，使用DriverManager
            Driver driver = (Driver) Class.forName(driverClass).newInstance();


            Properties info = new Properties();


            info.put("user", user);
            info.put("password", password);
            is.close();
            connection = driver.connect(jdbcUrl, info);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
