package day21JDBC;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by cdx on 2019/8/4.
 * desc:
 */
public class Testjdbc {
    private static final String TAG = "Testjdbc";

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

            Driver driver = (Driver) Class.forName(driverClass).newInstance();


            Properties info = new Properties();


            info.put("user", user);
            info.put("password", password);

            connection = driver.connect(jdbcUrl, info);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
