package day09;

/**
 * Created by cdx on 2019/1/17.
 * desc:
 */
public class GeometricObject {
    private static final String TAG = "GeometricObject";
    protected String clor;
    protected double weight;
    protected GeometricObject(){
        super();
        this.clor="white";
        this.weight=1.0;
    }

    public GeometricObject(String clor, double weight) {
        this.clor = clor;
        this.weight = weight;
    }

    public String getClor() {
        return clor;
    }

    public void setClor(String clor) {
        this.clor = clor;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
