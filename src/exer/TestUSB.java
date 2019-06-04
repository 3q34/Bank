package exer;

import java.util.Scanner;

/**
 * Created by cdx on 2019/2/18.
 * desc:
 */
public class TestUSB {
    private static final String TAG = "TestUSB";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
// 先读取键盘输入的字符串
        System.out.println("input name :");
        String name = sc.nextLine();
// 后读取键盘输入的int值
        System.out.println("input id :");
        int id = sc.nextInt();
        System.out.println("input id1 :");
        String  id2 = sc.next();
        System.out.println("execute finish !");
        System.out.println(id2);
        String  id3 = sc.next();
        System.out.println(id3);
        //System.out.println("id = " + id + " name =[" + name + "]"+"id =" + id1);
        System.out.println("execute finish !");
        //TestUSB testUSB=new TestUSB();
        //testUSB
        Computer computer=new Computer();
        computer.doWork(new Printer());
        Flash flash=new Flash();
        computer.doWork(flash);
        //接口匿名类
        USB phone=new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机停止工作");
            }
        };
        computer.doWork(new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机停止工作");
            }
        });
    }
}
interface USB{
    void start();
    void stop();
}
class Computer{
    public void doWork(USB usb){
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        usb.start();
        System.out.println("此设备开始操作");
        usb.stop();
        System.out.println("此设备停止操作");
    }
}
class Printer implements USB{
    public void start(){
        System.out.println("打印机开始工作");
    }
    public void stop(){
        System.out.println("打印机停止工作");
    }
}
class Flash implements USB{
    public void start(){
        System.out.println("U盘开始工作");
    }
    public void stop(){
        System.out.println("U盘停止工作");
    }
}
