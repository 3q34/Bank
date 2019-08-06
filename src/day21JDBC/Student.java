package day21JDBC;

/**
 * Created by cdx on 2019/8/6.
 * desc:
 */
public class Student {
    private static final String TAG = "Student";
    int id;
    String name;
    int age;
    String adress;

    public Student() {
        super();
    }

    public Student(int id, String name, int age, String adress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }

}
