package day16Thread;

/**
 * Created by cdx on 2019/7/7.
 * desc:
 */
 class Singleton {
    private static final String TAG = "Singleton";

    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}

