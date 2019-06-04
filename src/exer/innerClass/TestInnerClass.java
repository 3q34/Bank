package exer.innerClass;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public class TestInnerClass {
    private static final String TAG = "TestInnerClass";

    public static void main(String[] args) {
        //创建外部类的对象，通过外部类的对象调用内部类的构造器
        Person p = new Person();
        Person.Bird b = p.new Bird();
        //创建静态内部类的对象，直接通过外部类调用静态内部类的构造器
        Person.Dog p1 = new Person.Dog();
        b.info();
        
    }
}

class Person {
    String name;
    int age;

    class Bird {
        String name;
        int id;

        public Bird() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public void info() {
            show();
        }
    }

    public void show() {
        System.out.println("我是show方法");
    }

    static class Dog {

    }
}