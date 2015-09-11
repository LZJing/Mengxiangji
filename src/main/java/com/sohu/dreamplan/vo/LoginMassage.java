package com.sohu.dreamplan.vo;

/**
 * Created by lizha on 2015/9/8.
 */
public class LoginMassage {
    private Boolean Success;
    private String Message;
    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public LoginMassage() {
    }

    public LoginMassage(Boolean success, String message, UserInfo userInfo) {
        Success = success;
        Message = message;
        this.userInfo = userInfo;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
