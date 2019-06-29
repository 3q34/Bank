package day14.TestGeneric;

/**
 * Created by cdx on 2019/6/27.
 * desc:
 */
public class TestCustomDAO {
    private static final String TAG = "TestCustomDAO";

    public static void main(String[] args) {
        CustomDAO customDAO=new CustomDAO();
        customDAO.add(new CustomDAO());
        customDAO.getForList(0);
        customDAO.get(0);
    }
}
