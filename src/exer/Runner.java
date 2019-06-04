package exer;

/**
 * Created by cdx on 2019/1/20.
 * desc:
 */
public abstract interface Runner {
    //private static final String TAG = "Runner";
    void start();
    void run();
    void  stop();
}
class Person implements Runner{
    @Override
    public void start() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
    class  Car implements Runner{
        @Override
        public void start() {

        }

        @Override
        public void run() {

        }

        @Override
        public void stop() {

        }
        public void fillFuel(){

        }
        public void crack(){

        }
    }
}
class Bird implements  Runner{
    @Override
    public void start() {

    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
    public void fly(){

    }
}
