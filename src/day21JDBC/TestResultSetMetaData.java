package day21JDBC;

import org.junit.Test;

import javax.security.auth.Subject;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static day21JDBC.JDBCTools.getConnection;

/**
 * Created by cdx on 2019/8/8.
 * desc:描述ResultSet的元数据对象，即从中可以获取到结果集中列、列名
 */
public class TestResultSetMetaData {
    private static final String TAG = "TestResultSetMetaData";

    @Test
    public void test() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Student> list=null;
        String sql = "select id,name,age,address from student where Id=?";
        try {
            con = getConnection();

            //获取SQL语句的statement对象

            ps = con.prepareStatement(sql);
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i + 1, args[i]);
//            }
            ps.setInt(1, 5);
            resultSet = ps.executeQuery();
            HashMap<String, Object> hashmap = new HashMap<>();

            while (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);//指定列的别名。从1开始
                    Object columnValue = resultSet.getObject(columnLabel);
                    hashmap.put(columnLabel, columnValue);
                }
            }
            Class clazz=Student.class;
            Object entity=clazz.newInstance();
            for(HashMap.Entry<String,Object> obj:hashmap.entrySet()){
                Field f=entity.getClass().getField(obj.getKey());
                f.set(entity,obj.getValue());
            }
            System.out.println(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(con, ps, resultSet);
        }
    }

}
