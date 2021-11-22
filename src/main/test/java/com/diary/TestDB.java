package com.diary;


import com.diary.util.DBUtil;

public class TestDB {
    public void testConnection(){
        System.out.println(DBUtil.getConnection());
    }

}
