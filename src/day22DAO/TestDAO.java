package day22DAO;

import day21JDBC.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by cdx on 2019/8/9.
 * desc:
 */
public class TestDAO {
    private static final String TAG = "TestDAO";
    @Test
    public void testUpdate(){
        String sql ="insert into student(name,age,address,password) values(?,?,?,?)";
        DAO.update(sql,"黎明",44,"北京","!QAZ2wsx");
    }
    @Test
    public void testQuery(){
        String sql="select id,name,age,address,password from student where id=?";
       Student student= DAO.get(Student.class,sql,8);
        System.out.println(student);
    }
    @Test
    public void testGetlist(){
        String sql="select id,name,age,address,password from student where id=? or id=?";
        List<Student> student= DAO.getList(Student.class,sql,8,9);
        System.out.println(student);
    }
    @Test
    public void testGetValue(){
        String sql="select password from student where id=? ";
        String psw= DAO.getValue(sql,9);
        System.out.println(psw);
    }
}
