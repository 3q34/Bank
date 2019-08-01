package day19Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cdx on 2019/8/1.
 * desc:
 */
public class TestProxy1 {
    private static final String TAG = "TestProxy1";

    public static void main(String[] args) {
        IWork teachwork = new TeacherWork();//创建被代理类的对象
        WorkProxy workProxy = new WorkProxy(teachwork);//创建实现Proxy接口的类的对象
        IWork work = (IWork) workProxy.createWorkProxy();//创建代理类的对象
        work.teach();//实现方法
    }
}

interface IWork {
    void teach();
}

class TeacherWork implements IWork {
    @Override
    public void teach() {
        System.out.println("老师上课");
    }

}

class WorkProxy implements InvocationHandler {
    Object obj;

    public WorkProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(obj, args);
    }

    public Object createWorkProxy() {

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

}