package day21JDBC;

import javax.security.auth.Subject;
import java.util.List;

/**
 * Created by cdx on 2019/8/7.
 * desc:
 */
public class TestQuery {
    private static final String TAG = "TestQuery";

    public static void main(String[] args) {
        String sql = "select id,name,age,address from student where Id=? or Id=?";
        List<Student> student = JDBCTools.get(Student.class, sql, 4, 5);
        System.out.println(student);

    }
}
