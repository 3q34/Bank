package day19Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cdx on 2019/7/31.
 * desc:
 */

//动态代理的使用
//需要实现的接口，买房子
interface Subject {
    void action();
}

//被代理类
//我
class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("我是被代理类");
    }
}

//代理类，中介代替我买房,任意可以代理，动态创建
class MyInvocationHandler implements InvocationHandler {
    Object obj;//实现接口的被代理类的对象的声明

    //被代理类的对象实例化
    //返回动态的代理类的对象
    public Object blind(Object obj) {

        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);

    }

    //当通过代理类的对象，发起对被重写的方法的调用时，都会转化为对如下invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnVal = method.invoke(obj, args);
        return returnVal;
        //return  null;
    }
}


public class TestProxy {
    private static final String TAG = "TestProxy";

    public static void main(String[] args) {
        //创建被代理类的对象
        RealSubject realSubject = new RealSubject();
        //创建实现接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        //调用blind方法，动态返回一个同样实现Subject接口的代理类的对象
        Object obj = handler.blind(realSubject);
        Subject subject = (Subject) obj;//强制转换为接口对象,即代理类对象
        subject.action();//此方法一执行，转到Invoke方法的调用
    }
}
