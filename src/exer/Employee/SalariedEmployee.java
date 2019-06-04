package exer.Employee;

import exer.Employee.Employee;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
 class SalariedEmployee extends Employee {
    private static final String TAG = "SalariedEmployee";

    private double monthSalary;

    public double earnings() {
        return monthSalary;
    }

    public SalariedEmployee(double monthSalary, String name, int number, Mydate birthday) {
        super(name, number, birthday);
        this.monthSalary = monthSalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +super.toString()+
                "monthSalary='" + monthSalary + '\'' +
                '}';
    }
}

