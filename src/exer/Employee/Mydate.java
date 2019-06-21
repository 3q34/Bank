package exer.Employee;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public class Mydate {
    private static final String TAG = "Mydate";

    private int month;
    private int day;
    private int year;

    public Mydate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }



    @Override
    public String toString() {
        return "Mydate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }
}

