package day09;

import day08.day08_07.Man;

import java.util.Objects;

/**
 * Created by cdx on 2019/1/17.
 * desc:
 */
public class Circle extends GeometricObject {
    private static final String TAG = "Circle";
    protected double radius;
    private int ss;

    public Circle(String clor, double weight, double radius) {
        super(clor, weight);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    private Circle() {
        clor = "white";
        weight = 1.0;
        radius = 1.0;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(radius);
        return (int) (temp ^ (temp >>> 32));
    }

    //    public boolean equals(Circle c){
//       return this.radius==c.radius;
//    }
    public  String toString(){
        return radius+"";
    }

}
