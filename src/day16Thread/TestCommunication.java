package day16Thread;

/**
 * Created by cdx on 2019/7/8.
 * desc:线程通信
 */
public class TestCommunication {
    private static final String TAG = "TestCommunication";

    public static void main(String[] args) {
        PrintNumber pn = new PrintNumber();
        Thread t1 = new Thread(pn);
        Thread t2 = new Thread(pn);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}

class PrintNumber implements Runnable {
    int num = 1;

    public synchronized void run() {
        while (true) {
            notify();
            if (num < 100) {

                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + num);
                num++;
            } else break;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}