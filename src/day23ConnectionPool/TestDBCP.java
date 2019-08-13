package day23ConnectionPool;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * Created by cdx on 2019/8/12.
 * desc:
 */
public class TestDBCP {
    private static final String TAG = "TestDBCP";


    //DataSource接口，刚接口通常由服务器提供实现DBCP、C3P0
    //数据源，连接池、管理
    @Test
    public void test() throws SQLException {


        BasicDataSource ds = new BasicDataSource();
        //ds.setUrl();
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql:///mtc_base");
        ds.setDriverClassName("com.mysql.jdbc.Driver");

        ds.setInitialSize(5);
        ds.setMaxTotal(5);
        // 空闲状态下连接池中保留的最大的活动连接数
        ds.setMaxIdle(50);

        //空闲状态下连接池中保存的最少的活动连接数
        ds.setMinIdle(10);
        //等待数据连接池分分配连接的最长时间，ms,超出时间抛超时异常
        ds.setMaxWaitMillis(1000 * 5);
        Connection con = ds.getConnection();
        System.out.println(con);
        con = ds.getConnection();
        System.out.println(con);
        con = ds.getConnection();
        System.out.println(con);
        con = ds.getConnection();
        System.out.println(con);

        Connection con2 = ds.getConnection();
        System.out.println(con);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Connection con = ds.getConnection();//5秒内获取到不会报异常
                    System.out.println(con.getClass());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        try {
            Thread.sleep(3000);//三秒释放连接资源
            con2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl(connectURI);
        return ds;
    }

    public static void shutdownDataSource(DataSource ds) throws SQLException {
        BasicDataSource bds = (BasicDataSource) ds;
        bds.close();
    }


    //Properties中的键值对必须来自BasicDataSource的属性，否则不能识别
    @Test
    public void testDataSourceFactory() {
        try {
            Properties properties = new Properties();
            InputStream is = this.getClass().getResourceAsStream("dbcp.properties");

            properties.load(is);
            DataSource dataSourceFactory = BasicDataSourceFactory.createDataSource(properties);
            System.out.println(dataSourceFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
