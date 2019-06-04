package exer;

/**
 * Created by cdx on 2019/5/28.
 * desc:
 * 工厂方法的设计模式
 */
 public class TestFactoryMethods {
    private static final String TAG = "TestfactoryMethod";

    public static void main(String[] args) {
        IWorkFactory i=new StudentWorkFactory();
        i.getWork().dowork();
        IWorkFactory it=new TeacherWorkFactory();
        it.getWork().dowork();
    }


}
interface  IWorkFactory{
    Work getWork();
}
class StudentWorkFactory implements IWorkFactory{
    @Override
    public Work getWork() {
        return new StudentWork();
    }
}
class TeacherWorkFactory implements IWorkFactory{
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
interface Work {
    void dowork();
}
class StudentWork implements Work {

    @Override
    public void dowork() {
        System.out.println("学生写作业");
    }
}
class TeacherWork implements Work {
    @Override
    public void dowork() {
        System.out.println("老师改作业");
    }
}
