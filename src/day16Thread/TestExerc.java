package day16Thread;

/**
 * Created by cdx on 2019/7/8.
 * desc:两人向同一账户存钱，每次1000，存三次
 * 交替存钱需要线程通信
 */
public class TestExerc {
    private static final String TAG = "TestExerc";

    public static void main(String[] args) {
        Account ac = new Account();
        Thread t1 = new Thread(ac);
        t1.setName("账户一");
        Thread t2 = new Thread(ac);
        t2.setName("账户二");
        t1.start();
        t2.start();

    }
}

class Account implements Runnable {
    int account;

    public synchronized void run() {
        for (int i = 0; i < 3; i++) {
            account += 1000;
            System.out.println(Thread.currentThread().getName() + "存钱1000元  " + "余额为：" + account + "元");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}