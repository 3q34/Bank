package day14.TestGeneric.exercise1;

import java.util.List;

/**
 * Created by cdx on 2019/6/29.
 * desc:
 */
public class TestDAO {
    private static final String TAG = "TestDAO";

    public static void main(String[] args) {
        DAO<User> dao=new DAO<>();
       // dao.map=new HashMap<String,User>();
        dao.save("1",new User(10,"1","黎明"));
        dao.save("2",new User(11,"2","郭富城"));
        dao.save("5",new User(11,"5","张学友"));
        dao.save("6",new User(11,"6","成龙"));
        dao.save("7",new User(11,"7","刘德华"));
        System.out.println(dao.get("1"));
        dao.update("2",new User(15,"3","李四"));
        dao.delete("1");
        List<User> list=dao.list();
        System.out.println(list);
    }
}
