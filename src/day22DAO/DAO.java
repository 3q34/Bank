package day22DAO;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static day21JDBC.JDBCTools.getConnection;
import static day21JDBC.JDBCTools.releaseDB;

/**
 * Created by cdx on 2019/8/8.
 * desc:
 */
public class DAO {
    private static final String TAG = "DAO";

    //增删改
    public static void update(String sql, Object... args) {
        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = getConnection();

            //获取SQL语句的statement对象

            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            boolean s = ps.execute();

            if (s) {
                System.out.println("数据更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            releaseDB(con, ps, null);
        }
    }

    //查，一条数据，返回一个对象
    public static <T> T get(Class<T> clazz, String sql, Object... args) {

        T entity = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            con = getConnection();
            //获取SQL语句的statement对象
            // ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                //另外一种获取字段名称的方法是：ResultSetMetaData对象的getXX方法
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnName = rsmd.getColumnLabel(i + 1);//注意：index从1开始
                    Object columnValue = resultSet.getObject(columnName);
                    hashMap.put(columnName, columnValue);
                }
                entity = clazz.newInstance();
                for (HashMap.Entry<String, Object> obj : hashMap.entrySet()) {
                    Field field = null;
                    try {
                        field = entity.getClass().getField(obj.getKey());
                        field.set(entity, obj.getValue());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(con, ps, resultSet);
            return entity;
        }
    }

    //查询多条数据，返回对象的集合
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        List<T> list = new ArrayList<>();
        T entity = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            con = getConnection();

            //获取SQL语句的statement对象

            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                //另外一种获取字段名称的方法是：ResultSetMetaData对象的getXX方法
                ResultSetMetaData rsmd = resultSet.getMetaData();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnName = rsmd.getColumnLabel(i + 1);//注意：index从1开始
                    Object columnValue = resultSet.getObject(columnName);
                    hashMap.put(columnName, columnValue);
                }


                entity = clazz.newInstance();
                for (HashMap.Entry<String, Object> obj : hashMap.entrySet()) {
                    Field field = null;
                    try {
                        field = entity.getClass().getField(obj.getKey());
                        field.set(entity, obj.getValue());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(con, ps, resultSet);
            return list;
        }
    }

    //查询返回某个记录的值，或统计的值
    public static <E> E getValue(String sql, Object... args) {
        E str = null;
        return str;

    }
}
