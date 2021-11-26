package com.diary;


import com.diary.util.DBUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDB {

    private static Logger logger = LoggerFactory.getLogger(DBUtil.class);


    @Test
    public void testConnection(){
        System.out.println(DBUtil.getConnection());

        logger.info("在{}时，获取数据库连接", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
