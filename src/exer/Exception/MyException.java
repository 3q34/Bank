package exer.Exception;

/**
 * Created by cdx on 2019/6/3.
 * desc:
 */
public class MyException extends RuntimeException {
    private static final String TAG = "MyException";
    static final long serialVersionUID = -7034897190745766939L;

    public MyException() {

    }

    public MyException(String msg) {
        super(msg);
    }
}
