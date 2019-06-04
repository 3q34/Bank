package exer.Employee;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
 class HourlyEmployee extends Employee {
    private static final String TAG = "HourlyEmployee";
    private double wage;
    private double hour;

    public HourlyEmployee( double wage, double hour,String name, int number, Mydate birthday) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public  double earnings(){
        return wage*hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +super.toString()+
                "wage=" + wage +
                ", hour=" + hour +
                '}';
    }
}
