package day23ConnectionPool;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import day21JDBC.JDBCTools;
import org.junit.Test;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by cdx on 2019/8/12.
 * desc:除了添加C3P0的jar包，还需要（mchange-commons-java-0.2.15.jar）
 */
public class TestC3P0 {
    private static final String TAG = "TestC3P0";


    @Test
    public void testComboPooledDataSource() {
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///mtc_base");
            cpds.setUser("root");
            cpds.setPassword("root");
            Connection con = cpds.getConnection();
            System.out.println(con);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //!!无法读取配置文件，因为xml配置文件的位置不对，
    // 放在src跟目录下，久可访问了
    @Test
    public void testc3p0Config() {
        try {
            DataSource ds = new ComboPooledDataSource("mySource");
            System.out.println(ds.getConnection());

            ComboPooledDataSource comboPooledDataSource=(ComboPooledDataSource)ds;
            System.out.println(comboPooledDataSource.getMaxStatements());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        try {
            Connection con= JDBCTools.getConnection1();
            System.out.println(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
