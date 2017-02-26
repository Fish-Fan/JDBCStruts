package com.company.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/26.
 */
public class BeanListMapper<T> implements RowMapper<List<T>> {
    private Class<T> clazz;

    public BeanListMapper(Class<T> clazz){
        this.clazz = clazz;
    }
    @Override
    public List<T> mapRow(ResultSet resultSet) throws SQLException {
        List<T> list = new ArrayList<T>();

        try {
            while (resultSet.next()){
                T object = clazz.newInstance();
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int count = resultSetMetaData.getColumnCount();

                for(int i = 1;i <= count;i++){
                    String colName = resultSetMetaData.getColumnLabel(i);
                    String methodName = "set" + colName.substring(0,1).toUpperCase() + colName.substring(1);
                    Object colValue = resultSet.getObject(colName);

                    Method[] methods = clazz.getMethods();
                    for(Method method : methods){
                        if(method.getName().equals(methodName)){
                            method.invoke(object,colValue);
                        }
                    }
                }

                list.add(object);
            }
            return list;


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
