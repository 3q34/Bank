package exer;

/**
 * Created by cdx on 2019/5/27.
 * desc:
 */
public class A {
    private static final String TAG = "A";

    public static void main(String[] args) {
        A a1=new A();
        A a2=new B ();
        B b=new B();
        C c=new C();
        a1.show(b);//a1为父类A的对象，调用的是A中的方法，没有B类型参数的方法，优先使用其父类类型的方法，即show(A obj) 即A and A
        a1.show(c);//a1为父类A的对象，调用的是A中的方法，存在C类型参数的方法，优先使用该方法，即show(C obj) 即 A and C
        a2.show(b);//a2是父类指向子类的对象，调用的是B类中的B类型参数的方法，B类中没有，所以到其父类A中查找，A中没有B类型参数的方法，所以优先使用其父类类型参数的方法，即show（A obj），
        // 但是该类型在其子类中有重写，这种情况，优先使用子类的show（A obj)方法，结果为B and A
        a2.show(c);//a2是父类指向子类的对象，调用的是B类中的C类型参数的方法，B类中没有，所以到其父类A中查找，A中有C类型参数的方法，所以优先使用其父类类型参数的方法，即show（C obj），
        // 结果为A and C

    }
    public void show(A obj){
        System.out.println("A and A ");
    }
//    public void show(B obj){
//        System.out.println("A and B");
//    }
    public void show(C obj){
        System.out.println("A and C");
    }
}
class B extends A{

    public void show(B obj){
        System.out.println("B and B");
    }
    @Override
    public  void show(A obj){
        System.out.println("B and A");
    }
}
class C  extends B{}