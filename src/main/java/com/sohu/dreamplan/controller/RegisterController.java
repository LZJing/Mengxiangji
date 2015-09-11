package com.sohu.dreamplan.controller;

import com.sohu.dreamplan.dao.UserDAOImpl;
import com.sohu.dreamplan.vo.LoginMassage;
import com.sohu.dreamplan.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Resource
	UserDAOImpl dao;



	//   /register/createuser?name=lizhaojing或者/register/createuser或者POST方法的参数
	@RequestMapping("/createuser")
	public @ResponseBody ResponseEntity<LoginMassage> createUser(@RequestParam(value="tel", required=false, defaultValue="World") String tel,
																 @RequestParam(value="password", required=false, defaultValue="World")String password) {

		logger.debug(tel + "  " + password);
		LoginMassage rm= new LoginMassage();
		UserInfo user = new UserInfo();
		user.setUserPhone(tel);
		user.setUserPassword(password);
		user.setUserCreateTime(Long.toString(System.currentTimeMillis()));


		rm.setSuccess(false);
		try {
			if (dao.isPhoneExist(tel)){
				rm.setMessage("is_existed");
			}else{
				dao.doCreateByPhone(user); //执行插入

				user = dao.doSelectByPhone(tel);//返回用户信息
				user.setUserPassword(null);//屏蔽掉密码
				rm.setUserInfo(user);

				rm.setSuccess(true); //如果没有异常，则成功
				logger.debug("Create new user success，tel"+tel);
			}
		}catch (Exception e){
			e.printStackTrace();
			rm.setMessage("insert_fault");//有异常，则失败
		}
		return new ResponseEntity<LoginMassage>(rm, HttpStatus.OK);
	}

}