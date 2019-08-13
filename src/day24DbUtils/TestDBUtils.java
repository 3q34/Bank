package day24DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import day21JDBC.JDBCTools;
import day21JDBC.Student;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.Test;

import javax.sql.DataSource;
import javax.xml.ws.handler.Handler;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cdx on 2019/8/13.
 * desc:使用DBUtils更新操作
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

    @Test
    public void testQuery() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);
        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            ResultSetHandler<Student> h = new BeanHandler<>(Student.class);
            Student p = run.query(
                    "SELECT * FROM student WHERE name=?", h, "John Doe");
            System.out.println(p);
        } catch (Exception sqle) {
            // Handle it
        }
    }

    @Test
    public void testQueryList() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);
        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //因此，如果结果集中有多条记录，则应采用BeanListHandler
            ResultSetHandler r = new BeanListHandler<>(Student.class);
            List<Student> list = run.execute(
                    "SELECT * FROM student WHERE name=? or name=?", r, "John Doe", "刘德华");
            System.out.println(list);

        } catch (Exception sqle) {
            // Handle it
        }
    }
    @Test
    public void testQueryMap() {
        DataSource dataSource = JDBCTools.getDataSource();

        QueryRunner run = new QueryRunner(dataSource);

        try {
            //BeanHandler:将结果集的第一条数据转为 “创建BeanHandler对象时 传入的Class参数 所对应的对象”
            //ResultSetHandler<Student> h = new BeanHandler<>(Student.class);

            //因此，如果结果集中有多条记录，则应采用BeanListHandler
            Map<String,Object> map =  run.query(
                    "SELECT name,age FROM student WHERE id=?",new MapHandler(),9);
            System.out.println(map);

//            Student p = run.query(
//                    "SELECT * FROM student WHERE name=?", h, "John Doe");
//            System.out.println(p);
        } catch (Exception sqle) {
            // Handle it
        }
    }
}
