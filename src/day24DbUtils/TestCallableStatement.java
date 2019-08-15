package day24DbUtils;

import day21JDBC.JDBCTools;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by cdx on 2019/8/14.
 * desc:
 */
public class TestCallableStatement {
    private static final String TAG = "TestCallableStatement";

    @Test
    public void test() {
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = JDBCTools.getConnection1();
            //存储过程或函数组成的sql语句

            String sql = "{?=procedurename(?,?)}";
            cs = con.prepareCall(sql);

            //通过CallableStatement对象的registerOutParameter方法注册输出参数
            cs.registerOutParameter(1, Types.NUMERIC);
            cs.registerOutParameter(3, Types.NUMERIC);

            cs.setInt(2, 80);
            //通过execute执行
            cs.execute();

            //有返回值输出，通过CallableStatement对象的getXX方法获取

            double salary = cs.getDouble(1);
            double count = cs.getDouble(3);
            System.out.println(salary);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, cs, null);
        }

    }
}
