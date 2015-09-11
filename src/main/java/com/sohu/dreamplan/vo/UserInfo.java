package com.sohu.dreamplan.vo;

import java.io.Serializable;

/**
 * Created by lizha on 2015/9/8.
 */
public class UserInfo implements Serializable{
    private int UserId;
    private String UserName;
    private String UserPassword;
    private String UserPhone;
    private String UserCreateTime;
    private String UserHeadImageURL;
    private String UserThirdId;
    private String UserNotes;
    private String UserCountry;

    public UserInfo(int userId, String userName, String userPassword, String userPhone, String userCreateTime, String userHeadImageURL, String userThirdId, String userNotes) {

        this.UserId = userId;
        this.UserName = userName;
        this.UserPassword = userPassword;
        this.UserPhone = userPhone;
        this.UserCreateTime = userCreateTime;
        this.UserHeadImageURL = userHeadImageURL;
        this.UserThirdId = userThirdId;
        this.UserNotes = userNotes;
    }
    public UserInfo(){}

    public String getUserCountry() {
        return UserCountry;
    }

    public void setUserCountry(String userCountry) {
        UserCountry = userCountry;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserCreateTime() {
        return UserCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        UserCreateTime = userCreateTime;
    }

    public String getUserHeadImageURL() {
        return UserHeadImageURL;
    }

    public void setUserHeadImageURL(String userHeadImageURL) {
        UserHeadImageURL = userHeadImageURL;
    }

    public String getUserThirdId() {
        return UserThirdId;
    }

    public void setUserThirdId(String userThirdId) {
        UserThirdId = userThirdId;
    }

    public String getUserNotes() {
        return UserNotes;
    }

    public void setUserNotes(String userNotes) {
        UserNotes = userNotes;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                ", UserPhone='" + UserPhone + '\'' +
                ", UserCreateTime='" + UserCreateTime + '\'' +
                ", UserHeadImageURL='" + UserHeadImageURL + '\'' +
                ", UserThirdId='" + UserThirdId + '\'' +
                ", UserNotes='" + UserNotes + '\'' +
                ", UserCountry='" + UserCountry + '\'' +
                '}';
    }
}
