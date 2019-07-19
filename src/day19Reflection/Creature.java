package day19Reflection;

/**
 * Created by cdx on 2019/7/18.
 * desc:
 */
public class Creature<T> {
    private static final String TAG = "Creature";
    double weight;
    public void breath(){
        System.out.println("呼吸！");
    }
}
