package exer.innerClass;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public class JubuInnerClass {
    private static final String TAG = "JubuInnerClass";
}

class OuterClass {
    //以下使用较少
    public void method1() {
        class InnnerClass {
        }
    }
    //常常使用一个方法，使其返回值为某个类或接口的对象
    public Comparable getComparable(){
        //创建一个实现Comparable接口的类
        class  MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        //返回一个是实现类的对象
        return new MyComparable();
    }
}