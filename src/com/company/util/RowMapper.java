package com.company.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/25.
 */
public interface RowMapper<T> {
    public T mapRow(ResultSet resultSet) throws SQLException;
}
