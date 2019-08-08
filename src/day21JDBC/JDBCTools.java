package day21JDBC;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Properties;

/**
 * Created by cdx on 2019/8/7.
 * desc:JDBC工具
 */
public class JDBCTools {
    private static final String TAG = "JDBCTools";

    /**
     * 数据库连接方法
     */
    public static Connection getConnection() {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;
        Connection con = null;
        try {
            //配置文件获取参数信息
            Properties properties = new Properties();
            InputStream is = JDBCTools.class.getResourceAsStream("jdbc.properties");
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
            //System.out.println(con);
            return con;
        }
    }

    /**
     * 释放数据库连接资源的方法
     */

    public static void releaseDB(Connection con, Statement statement, ResultSet resultSet) {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    /*
     * 数据库更新方法
     * */
    public static void updateInfo(String sql) {

        Connection con = null;
        Statement statement = null;

        try {

            con = getConnection();

            //获取SQL语句的statement对象

            statement = con.createStatement();

            int s = statement.executeUpdate(sql);
            if (s > 0) {
                System.out.println("数据更新成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            releaseDB(con, statement, null);
        }

    }

    /*
     * 数据库查询方法
     * */

    public static ResultSet getInfo(String sql) {

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            con = getConnection();

            //获取SQL语句的statement对象

            statement = con.createStatement();

            resultSet = statement.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(con, statement, resultSet);
            return resultSet;
        }

    }


    /*
     * 查询返回数据类的对象,只适合一条数据的情况，会被重写
     * */

    public static <T> List<T> get(Class<T> clazz, String sql, Object... args) {
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
                //通过解析sql语句，判断含有的字段
                String str = subString(sql, "select", "from").replace(" ", "");
                String[] strings = str.split(",");
                for (int i = 0; i < strings.length; i++) {
                    hashMap.put(strings[i], resultSet.getObject(i + 1));
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

    public static String subString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }
}
