package day19Reflection;

/**
 * Created by cdx on 2019/7/11.
 * desc:Perdon类
 */

@MyAnnotation(value="haha")
public class Person extends Creature<String> implements Comparable,MyInterface {
    private static final String TAG = "Person";
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
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

    public void show() {
        System.out.println("你的名字是：" + this.name);
    }

    public void display(String nation) {
        System.out.println("我的国籍是：" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    class Bird{
        
    }
    public static void info(){
        System.out.println("我是静态方法");
    }
}
