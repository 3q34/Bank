package day14.TestGeneric;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdx on 2019/6/26.
 * desc:
 */
public class Order<T> {
    private static final String TAG = "Order";
    private String oerderName;
    private int orderId;
    private T t;//自定义类型，可以使用各种数据类型。
    List<T> list = new ArrayList<>();

    //泛型方法:泛型方法中传入什么类型，就返回什么类型的数据类型，可以跟泛型类中的类型不同
    public <E> E getE(E e) {
        return e;
    }

    public void add() {
        list.add(t);
    }

    public String getOerderName() {
        return oerderName;
    }

    public void setOerderName(String oerderName) {
        this.oerderName = oerderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oerderName='" + oerderName + '\'' +
                ", orderId=" + orderId +
                ", t=" + t +
                '}';
    }
}

//集成泛型类或泛型接口时，可以指明泛型的类型
//class SubOrder extends Order<Integer> {

class SubOrder<T> extends Order<T> {
}