package com.diary.dao;

import com.diary.po.User;
import com.diary.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    public User queryUserByName(String userName){
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=DBUtil.getConnection();
            String sql = "select * from tb_user where uname = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,userName);
            resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setUserId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet,preparedStatement,connection);
        }
        return user;
    }
}
