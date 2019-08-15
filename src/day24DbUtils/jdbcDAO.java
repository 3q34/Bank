package day24DbUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by cdx on 2019/8/14.
 * desc:
 */
public class jdbcDAO<T> implements DAO<T> {

    private QueryRunner runner = null;
    private Class<T> type;

    public jdbcDAO() {
        this.runner = new QueryRunner();
        this.type = ReflectionUtils.getSuperGenericType(getClass());
    }

    @Override
    public <E> E getValue(Connection con, String sql, Object... args) throws SQLException {
        return (E) runner.query(con, sql, new ScalarHandler(), args);
    }

    @Override
    public T getObject(Connection con, String sql, Object... args) throws SQLException {
        return runner.query(con, sql, new BeanHandler<>(type), args);
    }

    @Override
    public int update(Connection con, String sql, Object... args) throws SQLException {
        return runner.update(con, sql, args);
    }

    @Override
    /*
     * @Author cdx
     * @param con :
     * @param sql :
     * @param args :
     * @return java.util.List<T>
     * @throws
     * @Date 2019/8/14 18:01
     */
    public List<T> getList(Connection con, String sql, Object... args) throws SQLException {
        return runner.query(con, sql, new BeanListHandler<>(type), args);
    }

    @Override
    /*
     * @Author cdx
     * @param con :
     * @param sql :
     * @param args :
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     * @Date 2019/8/14 17:55
     */

    public Map<String, Object> getMap(Connection con, String sql, Object... args) throws SQLException {
        return runner.query(con, sql, new MapHandler(), args);
    }

    private static final String TAG = "jdbcDAO";
}
