package day16Thread;

/**
 * Created by cdx on 2019/7/6.
 * desc:通过接口实现售票窗口
 */
class PrintNum1 implements Runnable {

    public void run() {
        for (int i = 0; i <= 100; i++)
            System.out.println(i);
    }
}
