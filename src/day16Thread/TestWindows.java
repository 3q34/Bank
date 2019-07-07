package day16Thread;

/**
 * Created by cdx on 2019/7/6.
 * desc:模拟火车站多窗口售票
 */
public class TestWindows {
    private static final String TAG = "TestWindows";

    public static void main(String[] args) {
        Window w1=new Window();
        w1.setName("窗口1");
        Window w2=new Window();
        w2.setName("窗口2");
        w1.start();
        w2.start();
    }


}

class Window extends Thread {
    static int ticket = 100;

    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售票，票号为：" + ticket--);

        }
    }

}