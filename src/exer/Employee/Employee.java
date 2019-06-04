package exer.Employee;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public abstract class Employee {
    private static final String TAG = "Employee";
    private String name;
    private int number;
    private Mydate birthday;
  public   abstract double earnings();

    public Employee(String name, int number, Mydate birthday) {
        super();
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public Mydate getBirthday() {
        return birthday;
    }

    public void setBirthday(Mydate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

