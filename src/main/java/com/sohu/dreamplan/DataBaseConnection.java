package com.sohu.dreamplan;

import com.sohu.dreamplan.controller.RegisterController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lizha on 2015/9/8.
 */
@Component
public class DataBaseConnection {
    private static Logger logger = LoggerFactory.getLogger(DataBaseConnection.class);

    @Resource
    private DataSource dataSource;

    private Connection conn;


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }


    public Connection getConnection(){
        try{
            conn = dataSource.getConnection();
            //logger.debug("Load DB Success");
        }catch(Exception e){
            //logger.debug("Load DB Failed");
        }
        return conn;
    }

    //关闭数据库连接
    public void close(){
        try {
            if(conn!=null) {
                conn.close();
            }
            //logger.debug("Close DB Success");
        } catch (SQLException e) {
            e.printStackTrace();
            //logger.debug("Close DB Failed");
        }

    }
}
