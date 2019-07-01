package day14.Annotation;

/**
 * Created by cdx on 2019/7/1.
 * desc:注解
 * 1三种常用的注解
 * //@override重写
 * //@deprecated过时，新旧版本过渡
 * //@suppressWainings抑制编辑器警告
 * 2、自定义注解
 * 3、元注解:注解上的注解类型：retention，target，documented，inherited 
 */
public class TestAnnotation {
    private static final String TAG = "TestAnnotation";

    public static void main(String[] args) {
        Student student = new Student();
        student.walk();
        student.eat();
    }

}

@MyAnnotation(value = "haha")
//自定义注解
class Student extends Person {
    @Override
    void walk() {
        System.out.println("哈哈");
    }

    @Override
    void eat() {
        System.out.println("haohaochifan");
    }
}

class Person {
    String name;
    int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void walk() {

    }

    @Deprecated
        //删除,过时,新旧版本过渡
    void eat() {
    }

    void sleep() {
    }
}
