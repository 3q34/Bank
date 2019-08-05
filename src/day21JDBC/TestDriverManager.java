package day21JDBC;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by cdx on 2019/8/5.
 * desc:获取数据库连接的方法：DriverManager
 * 1可以通过getConnection重载获取数据连接
 * 2可以管理多个驱动程序
 */
public class TestDriverManager {
    private static final String TAG = "TestDriverManager";

    @Test
    public void test() {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;
        Connection con = null;
        try {
            //配置文件获取参数信息
            Properties properties = new Properties();
            InputStream is = this.getClass().getResourceAsStream("jdbc.properties");
            properties.load(is);
            driverClass = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Properties info = new Properties();
            info.put("user", user);
            info.put("password", password);
            is.close();
            //加载数据库驱动（注册驱动）

            //不再注册实例，是因为Driver类中有静态代码块已经实现了注册
            // DriverManager.registerDriver((Driver) Class.forName(driverClass).newInstance());
            Class.forName(driverClass);

            //DriverManager优点：可以注册多个jdbc连接

            //接口实现
            con = DriverManager.getConnection(jdbcUrl, info);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(con);
        }
    }
}
