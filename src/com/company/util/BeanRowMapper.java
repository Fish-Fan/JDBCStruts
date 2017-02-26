package com.company.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/2/26.
 */
public class BeanRowMapper<T> implements RowMapper<T> {
    private Class<T> clazz;

    public BeanRowMapper(Class<T> clazz){
        this.clazz = clazz;
    }

    @Override
    public T mapRow(ResultSet resultSet) throws SQLException {
        try {
            //用所传对象新建一个实例对象(object即为新建实例对象)
            T object = clazz.newInstance();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            //获取结果集的列数
            int count = resultSetMetaData.getColumnCount();

            if(resultSet.next()){
                for(int i = 1;i <= count;i++){
                    String colName = resultSetMetaData.getColumnLabel(i);
                    String methodName = "set" + colName.substring(0,1).toUpperCase() + colName.substring(1);
                    Object colValue = resultSet.getObject(colName);

                    //Java反射机制,其作用是使其返回一个完整的实例对象
                    Method[] methods = clazz.getMethods();
                    for(Method method : methods){
                        if(method.getName().equals(methodName)){
                            method.invoke(object,colValue);
                        }
                    }
                }
            }

            return object;

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
