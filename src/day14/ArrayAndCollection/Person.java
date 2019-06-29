package day14.ArrayAndCollection;

/**
 * Created by cdx on 2019/6/18.
 * desc:
 */
public class Person implements Comparable {
    private static final String TAG = "Person";
    private String name;
    private Integer age;



    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return age != null ? age.equals(person.age) : person.age == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //添加person类型是按照此方法中的属性排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p=(Person)o;
            return this.name.compareTo(p.name);
        }
        return 0;
    }
}
