package day16Thread;

/**
 * Created by cdx on 2019/7/7.
 * desc:同步监视器由一个类的对象充当。哪个线程获取此监视器，谁就执行被同步的代码。俗称，锁
 */
public class TestSynchronized {
    private static final String TAG = "TestSynchronized";

    public static void main(String[] args) {
//        Window3 w1 = new Window3();
//        Thread t1 = new Thread(w1);
//        Thread t2 = new Thread(w1);
//        Thread t3 = new Thread(w1);
//        t1.start();
//        t2.start();
//        t3.start();
        Window4 window4 = new Window4();
        Thread t1 = new Thread(window4);
        Thread t2 = new Thread(window4);
        Thread t3 = new Thread(window4);
        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    int ticket = 100;

    //Object obj = new Object();//同步监视器，锁
//
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(10);//使线程安全问题更加明显显示
                        System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}


class Window4 implements Runnable {
    int ticket = 100;

    //Object obj = new Object();//同步监视器，锁
//
    public void run() {
        while (true) {
            show();
        }
    }

    //将操作共享数据的方法声明为synchronised.此方法即为同步方法。
// 能够保证其中一个线程执行此方法时，其他线程在外等待，直至此线程执行完此方法。
// 同步方法的锁即调用的当前对象
    public synchronized void show() {

        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(10);//使线程安全问题更加明显显示
                System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}