package day16Thread;

import org.junit.Test;

/**
 * Created by cdx on 2019/7/5.
 * desc:创建一个线程，完成1-100输出，同时主线程也执行本操作
 * 创建多线程的第一种方法：继承Thread的类
 */
public class TestThread {
    private static final String TAG = "TestThread";

    public static void main(String[] args) {
        Thread t = new Thread(TestThread::test);
        t.start();
        // t.join();//使A线程执行过程中，另外的线程B强制执行，完成后再执行A线程
        //isAlive()   return boolean类型，是否存活
//        Thread t1 = new Thread(TestThread::test1);
//        t1.start();
//        t.run();
        SubThread st = new SubThread();
        st.start();
        for (int i = 1000; i >= 0; i--)
            System.out.println(Thread.currentThread().getName() + "-C" + i);

        PrintNum p1 = new PrintNum("线程1");
        p1.setPriority(Thread.MAX_PRIORITY);
        PrintNum p2 = new PrintNum("线程2");
        p2.setPriority(Thread.MIN_PRIORITY);
        p1.start();
        p2.start();

        //接口实现：实现的方式创建线程
        PrintNum1 pn = new PrintNum1();
        Thread t2 = new Thread(pn);
        t2.start();
        Thread t3 = new Thread(pn);
        t3.start();
    }

    //几个线程的方法
    @Test
    public void test2() {
        PrintNum p1 = new PrintNum("线程1");
        p1.setPriority(Thread.MAX_PRIORITY);
        PrintNum p2 = new PrintNum("线程2");
        p2.setPriority(Thread.MIN_PRIORITY);
        p1.start();
        p2.start();
    }

    public static void test() {
        for (int i = 1000; i >= 0; i--) {
            try {
                Thread.currentThread().sleep(1000);
                System.out.println(Thread.currentThread().getName() + "A" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test1() {
        System.out.println("呵呵呵");
    }
}

class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++)
            System.out.println(Thread.currentThread().getName() + "B" + i);
    }


}

class PrintNum extends Thread {
    public PrintNum(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i <= 1000; i++)
            System.out.println(Thread.currentThread().getName() + "B" + i);
    }
}