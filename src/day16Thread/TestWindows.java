package day16Thread;

/**
 * Created by cdx on 2019/7/6.
 * desc:模拟火车站多窗口售票
 */
public class TestWindows {
    private static final String TAG = "TestWindows";

    //存在线程安全问题。
// 不同线程处理打印时，由于时间延迟等造成每个线程都会执行一次打印，产生重复或者错误

    /**
     * 一个线程在操作过程中，未执行完毕，另外一个线程参与进来，导致共享数据存在安全问题
     * 线程的同步机制：必须让一个线程操作完毕之后，其他线程才有机会参与进来
     * 同步代码块
     *
     * 同步方法
     **/

    public static void main(String[] args) {
        Window w1 = new Window();
        w1.setName("窗口1");
        Window w2 = new Window();
        w2.setName("窗口2");
        Window w3 = new Window();
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }


}

class Window extends Thread {
    static int ticket = 100;
    static Object obj = new Object();

    public void run() {


        synchronized (obj) {
            while (ticket > 0) {
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