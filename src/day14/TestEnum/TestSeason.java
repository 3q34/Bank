package day14.TestEnum;

/**
 * Created by cdx on 2019/7/1.
 * desc:自定义枚举类
 */
public class TestSeason {
    private static final String TAG = "TestEnumSeason";

    public static void main(String[] args) {
        Season season = Season.SPRING;
    }
}

//自定义枚举类：数量有限
class Season {
    //1提供类的属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;

    //2单例模式：私有化构造器
    private Season(String seasonName, String seasonDesc) {
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

    //4创建对象
    public static final Season SPRING = new Season("Spring", "穿暖花开");
    public static final Season SUMMER = new Season("summer", "夏日炎炎");
    public static final Season AUTUMN = new Season("autumn", "秋高气爽");
    public static final Season WINTER = new Season("winter", "白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}