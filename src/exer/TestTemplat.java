package exer;

/**
 * Created by cdx on 2019/1/20.
 * desc:
 */
public abstract class  TestTemplat {
    public static void main(String[] args) {
       new SubTemplat().spendTime();
    }
    private static final String TAG = "TestTemplat";

}
abstract class Templat{
    abstract void code();
    public void spendTime(){
        long start=System.currentTimeMillis();
        code();
        long end=System.currentTimeMillis();
        System.out.println("花费时间为："+(end-start));
    }
}
class  SubTemplat extends Templat{
     @Override
     void code() {
         for(int i= 0; i < 1000; i++) {
             System.out.println(i);
         }


     }
 }
 interface According{
public static int I=12;
double f=2.0;
public abstract void method2();
void method3();

 }
interface According1{

    void method4();

}
 class BB implements According,According1{
     public  void method2(){};
     public void method3(){};
     public void method4(){};
 }
 abstract class CC implements According{

 }
 interface  DD extends According,According1{

 }