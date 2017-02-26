package com.company.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/25.
 */
public class DBHelp {
    public static void executeUpdate(String sql,Object...param){
        Connection connection = ConnectionManage.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 0;i < param.length;i++){
                preparedStatement.setObject(i+1,param[i]);
            }

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> T executeQuery(String sql,RowMapper<T> rowMapper,Object...param){
        Connection connection = ConnectionManage.getConnection();
        T object = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(int i = 0;i < param.length;i++){
                preparedStatement.setObject(i+1,param[i]);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            object = rowMapper.mapRow(resultSet);

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }

}
