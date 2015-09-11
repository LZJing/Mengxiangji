package com.sohu.dreamplan.controller;

import com.sohu.dreamplan.dao.UserDAOImpl;
import com.sohu.dreamplan.vo.LoginMassage;
import com.sohu.dreamplan.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lizha on 2015/9/10.
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    UserDAOImpl dao;


    /**
     * 登录功能
     * LoginURL:/login
     *
     * @param tel
     * @param password
     * @return
     */
    @RequestMapping("/phone")
    public @ResponseBody
    ResponseEntity<LoginMassage> login(@RequestParam(value="tel") String tel, @RequestParam(value="password")String password) {

        //logger.debug(tel + "  " + password);
        UserInfo user;
        LoginMassage rm= new LoginMassage();
        rm.setSuccess(false);
        try {
            if (dao.isPhoneExist(tel)){
                user = dao.doSelectByPhone(tel);
                if(user.getUserPassword().equals(password)){
                    rm.setSuccess(true);
                    rm.setMessage("login_success");
                    user.setUserPassword(null);//返回前把密码屏蔽
                    rm.setUserInfo(user);
                    logger.debug("id:" + user.getUserId() +" login success");
                }else{
                    rm.setMessage("wrong_password");
                }
            }else{
                rm.setSuccess(false);
                rm.setMessage("user_not_existed");
            }
        }catch (Exception e){
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMessage("server_error");//有异常，则失败
        }
        return new ResponseEntity<LoginMassage>(rm, HttpStatus.OK);
    }

    @RequestMapping("/thirdid")
    public @ResponseBody
    ResponseEntity<LoginMassage> loginByThirdId(@RequestParam(value="thirdid") String thirdid,
                                                @RequestParam(value="screen_name") String name,
                                                @RequestParam(value="profile_image_url") String imageURL) {

        //logger.debug(tel + "  " + password);
        UserInfo user = new UserInfo();
        user.setUserThirdId(thirdid);
        user.setUserName(name);
        user.setUserHeadImageURL(imageURL);
        user.setUserCreateTime(Long.toString(System.currentTimeMillis()));
        LoginMassage rm= new LoginMassage();
        rm.setSuccess(false);
        try {
            if (dao.isThirdIdExisted(thirdid)){//用户已存在
                user = dao.doSelectByThirdId(thirdid);
                rm.setSuccess(true);
                rm.setMessage("login_success");
                rm.setUserInfo(user);
                logger.debug("id:" + user.getUserId() +" login success");
            }else{
                dao.doCreateByThirdId(user);
                user = dao.doSelectByThirdId(thirdid);
                rm.setSuccess(true);
                rm.setMessage("create_new_user");
                rm.setUserInfo(user);
                logger.debug("id:" + user.getUserId() + " create success");
                logger.debug("id:" + user.getUserId() +" login success");
            }
        }catch (Exception e){
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMessage("server_error");//有异常，则失败
        }
        return new ResponseEntity<LoginMassage>(rm, HttpStatus.OK);
    }

}
