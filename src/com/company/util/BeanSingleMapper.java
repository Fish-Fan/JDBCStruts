package com.company.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/26.
 */
public class BeanSingleMapper<T> implements RowMapper<T> {

    @Override
    public T mapRow(ResultSet resultSet) throws SQLException {
        return (T) resultSet.getObject(1);
    }
}
