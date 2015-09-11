package com.sohu.dreamplan.dao;


import com.sohu.dreamplan.vo.UserInfo;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by lizha on 2015/9/8.
 */
//@Component
@Repository
public class UserDAOImpl implements IUserDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;


    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean doCreateByPhone(UserInfo userInfo) throws Exception {
        String sql = "INSERT INTO user_info(user_password,user_phone,user_createtime) VALUE (?,?,?)";
        this.preparedStatement=  this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,userInfo.getUserPassword());
        this.preparedStatement.setString(2,userInfo.getUserPhone());
        this.preparedStatement.setString(3, userInfo.getUserCreateTime());
        if(this.preparedStatement.executeUpdate()>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean doCreateByThirdId(UserInfo userInfo) throws Exception {
        String sql = "INSERT INTO user_info(user_name,user_thirdid,user_createtime,user_headimageURL) VALUE (?,?,?,?)";
        this.preparedStatement=  this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,userInfo.getUserName());
        this.preparedStatement.setString(2,userInfo.getUserThirdId());
        this.preparedStatement.setString(3, userInfo.getUserCreateTime());
        this.preparedStatement.setString(4, userInfo.getUserHeadImageURL());
        if(this.preparedStatement.executeUpdate()>0){
            return true;
        }
        return false;

    }

    @Override
    public UserInfo doSelectByPhone(String phone) throws Exception {
        UserInfo userInfo = null;
        String sql = "SELECT * From user_info where user_phone = ?";
        this.preparedStatement=  this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1,phone);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            userInfo = new UserInfo();
            userInfo.setUserId(resultSet.getInt("user_id"));
            userInfo.setUserName(resultSet.getString("user_name"));
            //userInfo.setUserPassword(resultSet.getString("user_password"));
            userInfo.setUserPhone(resultSet.getString("user_phone"));
            userInfo.setUserCreateTime(resultSet.getString("user_createtime"));
            userInfo.setUserHeadImageURL(resultSet.getString("user_headImageURL"));
            userInfo.setUserNotes(resultSet.getString("user_notes"));
            userInfo.setUserCountry(resultSet.getString("user_country"));
        }
        return userInfo;
    }

    @Override
    public UserInfo doSelectByThirdId(String thirdId) throws Exception {
        UserInfo userInfo = null;
        String sql = "SELECT * From user_info where user_thirdid = ?";
        this.preparedStatement=  this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, thirdId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            userInfo = new UserInfo();
            userInfo.setUserId(resultSet.getInt("user_id"));
            userInfo.setUserName(resultSet.getString("user_name"));
            //userInfo.setUserPassword(resultSet.getString("user_password"));
            //userInfo.setUserPhone(resultSet.getString("user_phone"));
            userInfo.setUserCreateTime(resultSet.getString("user_createtime"));
            userInfo.setUserHeadImageURL(resultSet.getString("user_headImageURL"));
            userInfo.setUserThirdId(resultSet.getString("user_thirdid"));
            userInfo.setUserNotes(resultSet.getString("user_notes"));
            userInfo.setUserCountry(resultSet.getString("user_country"));
        }
        return userInfo;
    }



    @Override
    public boolean isPhoneExist(String phone) throws Exception {
        String sql = "SELECT * From user_info where user_phone ='"+phone+"'";
        //conn = dbCon.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean isExist = rs.next();
        stmt.close();
        connection.close();
        return isExist;

    }

    @Override
    public boolean isThirdIdExisted(String thirdId) throws Exception {
        String sql = "SELECT * From user_info where user_thirdid ='"+thirdId+"'";
        //connection = dbCon.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean isExist = rs.next();
        stmt.close();
        connection.close();
        return isExist;
    }

}
