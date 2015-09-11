package com.sohu.dreamplan.service;

/**
 * Created by lizha on 2015/9/11.
 */
public interface ILoginService {

    /**
     *
     * @return
     * @throws Exception
     */
    public boolean registerByPhone() throws Exception;

    public boolean loginByPhone() throws Exception;

    public boolean loginByThirdId() throws Exception;


}
