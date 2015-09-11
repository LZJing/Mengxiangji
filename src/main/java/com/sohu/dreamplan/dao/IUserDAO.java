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
     * @return ����û����ڣ������û���Ϣ����������ڷ���null
     * @throws Exception
     */
    public UserInfo doSelectByPhone(String phone) throws Exception;

    /**
     * ���ݵ�����id����һ���û�
     * @param thirdId
     * @return ����û����ڣ������û���Ϣ����������ڷ���null
     * @throws Exception
     */
    public UserInfo doSelectByThirdId(String thirdId) throws Exception;



    /**
     *
     * ���绰�����Ƿ��Ѿ�����
     * @param phone Ҫ��ѯ�ĵ绰����
     * @return ���ڷ���true
     * @throws Exception
     */
    public boolean isPhoneExist(String phone) throws Exception;

    /**
     * ��������id�Ƿ��Ѿ�����
     * @param thirdId Ҫ��ѯ�ĵ�����id
     * @return ���ڷ���true
     * @throws Exception
     */
    public boolean isThirdIdExisted(String thirdId) throws  Exception;


}
