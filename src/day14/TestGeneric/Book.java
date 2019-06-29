package day14.TestGeneric;

/**
 * Created by cdx on 2019/6/26.
 * desc:
 */
public class Book {
    private static final String TAG = "Book";
    private String name;
    private int number;

    public Book(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
