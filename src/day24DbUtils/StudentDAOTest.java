package day24DbUtils;

import day21JDBC.JDBCTools;
import day21JDBC.Student;
import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by cdx on 2019/8/14.
 * desc:
 */
public class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();
    //DataSource dataSource = JDBCTools.getDataSource();
    Connection con = JDBCTools.getConnection1();

    public StudentDAOTest() throws SQLException {
    }

    @Test
    public void getValue() throws SQLException {
        String sql = "select name from student where id=? ";
        String result = studentDAO.getValue(con, sql, 8);
        System.out.println(result);
    }

    @Test
    public void getObject() throws SQLException {
        String sql = "select * from student where id=?";
        Student result = studentDAO.getObject(con, sql, 9);

        System.out.println(result);
    }

    @Test
    public void update() throws SQLException {
        String sql = "insert student (name,age)values (?,?)";
        int result = studentDAO.update(con, sql, "哪吒", 9);

        System.out.println(result);
    }

    @Test
    public void getList() throws SQLException {
        String sql = "select * from student where id=? or id=?";
        List<Student> result = studentDAO.getList(con, sql, 8, 9);
        System.out.println(result);
    }

    @Test
    public void getMap() throws SQLException {
        String sql = "select * from student where id=? ";
        Map<String, Object> result = studentDAO.getMap(con, sql, 8);
        System.out.println(result);
    }
}