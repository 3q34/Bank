package Map;

import org.junit.Test;

import java.util.*;

/**
 * Created by cdx on 2019/6/23.
 * desc:
 */
public class TestMapExcersize {
    private static final String TAG = "TestMapExcersize";

    // 将十个数字添加到数组中，从大到小排列
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(12);
        list.add(23);
        list.add(12);
        list.add(56);
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    //学生名和成绩录入到Map中，按照分数显示前三名学生的名字，查看ArrayCollection
    @Test
    public void test2() {
        Map m = new HashMap();
        m.put("zhangsan", 22);
        m.put("lisi", 21);
        m.put("wanger", 45);
    }
}
