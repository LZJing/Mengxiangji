package com.sohu.dreamplan.dao;

import com.sohu.dreamplan.vo.UserInfo;

/**
 * Interface of user information date persistence layer.
 * Created by lizhaojing on 2015/9/8.
 */
public interface IUserDAO {

    /**
     * Create a new user by phone number.
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean doCreateByPhone(UserInfo userInfo) throws Exception;

    /**
     * Create a new user by phone number.
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean doCreateByThirdId(UserInfo userInfo)throws Exception;

    /**
     * Find a user according to phone number.
     * @param phone
     * @return 如果用户存在，返回用户信息，如果不存在返回null
     * @throws Exception
     */
    public UserInfo doSelectByPhone(String phone) throws Exception;

    /**
     * 根据第三方id查找一个用户
     * @param thirdId
     * @return 如果用户存在，返回用户信息，如果不存在返回null
     * @throws Exception
     */
    public UserInfo doSelectByThirdId(String thirdId) throws Exception;



    /**
     *
     * 检查电话号码是否已经存在
     * @param phone 要查询的电话号码
     * @return 存在返回true
     * @throws Exception
     */
    public boolean isPhoneExist(String phone) throws Exception;

    /**
     * 检查第三方id是否已经存在
     * @param thirdId 要查询的第三方id
     * @return 存在返回true
     * @throws Exception
     */
    public boolean isThirdIdExisted(String thirdId) throws  Exception;


}
