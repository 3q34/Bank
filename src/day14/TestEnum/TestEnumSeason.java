package day14.TestEnum;

/**
 * Created by cdx on 2019/7/1.
 * desc:自定义枚举类
 */
public class TestEnumSeason {
    private static final String TAG = "TestEnumSeason";

    public static void main(String[] args) {
        EnumSeason season = EnumSeason.SPRING;
        //values方法
        EnumSeason[] enumSeasons = EnumSeason.values();
        for (EnumSeason e : enumSeasons) {
            System.out.println(e);
        }
        //valuesof方法
        EnumSeason.valueOf(new String("SPRING")).show();//如果传入的参数不存在，报错。
        Thread.State[] states = Thread.State.values();
        for (Thread.State c : states) {
            System.out.println(c);
        }
    }
}

//枚举类实现接口
interface Info {
    void show();
}


//自定义枚举类：数量有限
enum EnumSeason implements Info {

    //0创建对象,首行
    SPRING("Spring", "穿暖花开") {
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("summer", "生如夏花") {
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    AUTUMN("autumn", "秋高气爽") {
        public void show() {
            System.out.println("秋天是用来分手的季节？");
        }
    },
    WINTER("winter", "白雪皑皑") {
        public void show() {
            System.out.println("冬日暖阳");
        }
    };
    //1提供类的属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;

    //2单例模式：私有化构造器
    EnumSeason(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3调用属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    public String toString() {
        return "EnumSeason{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
//    public void show(){
//        System.out.println("这是季节");
//    }
}