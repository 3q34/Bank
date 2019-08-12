package day23ConnectionPool;


import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


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

        ds.setInitialSize(10);


        Connection con = ds.getConnection();
        System.out.println(con);
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
}
