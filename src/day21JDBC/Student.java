package day21JDBC;

/**
 * Created by cdx on 2019/8/6.
 * desc:
 */
public class Student {
    private static final String TAG = "Student";
    public int id;
    public String name;
    public int age;
    public String address;
    public String password;

    public Student() {
        super();
    }

    public Student(int id, String name, int age, String address, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
