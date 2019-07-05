package day15IO;

import org.junit.Test;

import java.io.*;

/**
 * Created by cdx on 2019/7/4.
 * desc:对象流
 * 对象的序列化机制
 */
public class TestObjectStream {
    private static final String TAG = "TestObjectStream";

    //反序列化
    @Test
    public void test1() {

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("D:\\2.txt"));
            Person p1 = (Person) ois.readObject();
            System.out.println(p1);
            Person p2 = (Person) ois.readObject();
            System.out.println(p2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //序列化
    @Test
    public void test() {
        try {
            Person p1 = new Person("小米", 12, new Pet("花花", 1));
            Person p2 = new Person("红米", 13, new Pet("Peggy", 2));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\1.txt"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\1.txt"));

            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.close();
        } catch (IOException e) {


        } finally {
        }

    }

}

/**
 * 类可序列化必须使用接口：Serializable和Externalizable
 * 类的属性也必须可序列化,即使用接口
 * 使用static或transient修饰的属性，不可实现序列化
 **/
class Person implements Serializable {
    private static final long serialVersionUID = 2122323;//表明版本之间的兼容性，类的不同版本具有相同的序列号
    String name;
    int age;
    Pet p;

    public Person(String name, int age, Pet p) {
        this.name = name;
        this.age = age;
        this.p = p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", p=" + p +
                '}';
    }
}

class Pet implements Serializable {
    String name;
    int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}