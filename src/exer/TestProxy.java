package exer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by cdx on 2019/5/29.
 * desc:
 */
public class TestProxy {
    private static final String TAG = "TestProxy";

    public static void main(String[] args) {
        Object t=new ProxyObject();
        t.action();

//        Collection n=new ArrayList();
//        n.add(1);
//        n.add(2);
//        System.out.println(n);
    }
}

interface Object{
    void action();
}
class ProxyObject implements Object{
    Object obj;
    public ProxyObject(){
        System.out.println("代理类创建成功");
        obj=new ObjectImpl();

    }

    public void action(){
        obj.action();
    }

}
class ObjectImpl implements Object{

    @Override
    public void action() {

    }
}