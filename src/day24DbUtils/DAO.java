package day24DbUtils;

import com.sun.org.glassfish.gmbal.Description;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by cdx on 2019/8/14.
 * desc:访问数据的DAO接口
 * 访问数据表的各种方法
 */
public interface DAO<T> {
    <E> E getValue(Connection con, String sql, Object... args) throws SQLException;

    T getObject(Connection con, String sql, Object... args) throws SQLException;


    int update(Connection con, String sql, Object... args) throws SQLException;

    List<T> getList(Connection con, String sql, Object... args) throws SQLException;

    Map<String, Object> getMap(Connection con, String sql, Object... args) throws SQLException;


}
