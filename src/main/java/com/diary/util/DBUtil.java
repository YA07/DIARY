package com.diary.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static Properties properties=new Properties();
    static{
        InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(in);
            Class.forName(properties.getProperty("jdbcName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            String dbUrl=properties.getProperty("dbUrl");
            String dbName=properties.getProperty("dbName");
            String dbPwd=properties.getProperty("dbPwd");

            connection= DriverManager.getConnection(dbUrl,dbName,dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static  void close(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection){
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
