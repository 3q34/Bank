package day08.day08_07;

/**
 * Created by cdx on 2019/1/16.
 * desc:
 */
public class TestInstance {
    private static final String TAG = "TestInstance";

    public static void main(String[] args) {

        TestInstance testInstance=new TestInstance();
        testInstance.funcion(new Student());
        testInstance.funcion(new Graduate());
    }
    public void funcion(Person p){
        System.out.println("p = [" + p.getInf() + "]");
    }

}
class Person{
    protected String name="哈哈";
    protected int age=20;
    public String  getInf(){
        return  "name="+name+"; age="+age;
    }
}
class Student extends Person{
    protected String school="spu";
    public String  getInf(){
        return  "name="+name+"; age="+age+";school="+school;
    }
}
class Graduate extends Student{
    public String major="IT";
    public String  getInf(){
        return  "name="+name+"; age="+age+";school="+school+"；major="+major;
    }
}