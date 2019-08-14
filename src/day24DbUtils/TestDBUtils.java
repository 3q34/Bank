package day24DbUtils;

import day21JDBC.JDBCTools;
import day21JDBC.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by cdx on 2019/8/13.
 * desc:使用DBUtils更新操作
 * query方法的使用关键是handler的使用，调用QueryRunner的query方法或者其父类方法实现查询结果集返回
 */
public class TestDBUtils {
    private static final String TAG = "TestDBUtils";

    @Test
    public void testUpdate() {

        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);
        try {
            // Execute the SQL update statement and return the number of
            // inserts that were made
            int inserts = run.update("INSERT INTO student (name,age) VALUES (?,?)",
                    "John Doe", 20);
            // The line before uses varargs and autoboxing to simplify the code

            // Now it's time to rise to the occation...
            int updates = run.update("UPDATE student SET age=? WHERE name=?",
                    43, "John Doe");
            // So does the line above
        } catch (SQLException sqle) {
            // Handle it
        }
    }

    /**
     * BeanHandler：单个对象或者javabean
     */
    @Test
    public void testQueryBeanHandler() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);
        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            //ResultSetHandler<Student> h = new BeanHandler<>(Student.class);
            Student p = run.query(
                    "SELECT * FROM student WHERE name=?", new BeanHandler<>(Student.class), "John Doe");
            System.out.println(p);
        } catch (Exception sqle) {
            // Handle it
        }
    }

    /**
     * BeanListHandler：对象的集合（javaBean的集合）
     */
    @Test
    public void testQueryBeanListHandler() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);

        try {

            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //因此，如果结果集中有多条记录，则应采用BeanListHandler
            ResultSetHandler r = new BeanListHandler<>(Student.class);
            BeanListHandler<Student> rr = new BeanListHandler<>(Student.class);
            List<Student> list = run.query(
                    "SELECT * FROM student WHERE name=? or name=?", rr, "John Doe", "刘德华");
            System.out.println(list);

        } catch (Exception sqle) {
            // Handle it
        }
    }

    /**
     * MapListHandler：键值对的集合
     */
    @Test
    public void testQueryMapListHandler() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);

        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            //ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //返回键值对
            List<Map<String, Object>> map = run.query(
                    "SELECT name,age FROM student WHERE id=? or id=?", new MapListHandler(), 9, 10);
            System.out.println(map);

        } catch (Exception sqle) {
            // Handle it
        }
    }

    /**
     * MapHandler：键值对
     * map对应查询的一条记录，键：查询的列名，不是别名，值：列的值
     */
    @Test
    public void testQueryMapHandler() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);

        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            //ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //返回键值对
            Map<String, Object> map = run.query(
                    "SELECT name,age FROM student WHERE id=?", new MapHandler(), 9);
            System.out.println(map);

        } catch (Exception sqle) {
            // Handle it
        }
    }

    /**
     * ScalarHandler:获取某个值或者统计值
     */
    @Test
    public void testQueryScalarHandler() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);

        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            //ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //返回键值对
            Object result = run.query(
                    "SELECT name FROM student WHERE id=?", new ScalarHandler<>(), 9);
            System.out.println(result.toString());

        } catch (Exception sqle) {
            // Handle it
        }
    }
}
