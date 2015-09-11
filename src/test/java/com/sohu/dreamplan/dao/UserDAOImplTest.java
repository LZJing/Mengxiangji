package com.sohu.dreamplan.dao;

import com.sohu.dreamplan.DataBaseConnection;
import com.sohu.dreamplan.vo.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class UserDAOImplTest {

    @Resource
    DataBaseConnection dataBaseConnection;

    @Resource
    UserDAOImpl userDAOImpl;
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

//    @Test
    public void simple() throws Exception {
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("hello"));
//        System.out.println("Test Start--------------");
        UserInfo user = new UserInfo();
        //user.setUserId(100000);
        user.setUserPhone("123");
        user.setUserPassword("202cb962ac59075b964b07152d234b70");
        System.out.println(userDAOImpl.doCreateByPhone(user));

    }
//    @Test
    public void doSelectByPhone() throws Exception {
        UserInfo user = userDAOImpl.doSelectByPhone("1231234");
        System.out.println(user.toString());

    }
 //   @Test
    public void doCreatByPhoneTest() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserPhone("999997");
        userInfo.setUserPassword("1111");
        userDAOImpl.setConnection(dataBaseConnection.getConnection());

        boolean success = userDAOImpl.doCreateByPhone(userInfo);
        System.out.println(success);

    }
//    @Test
    public void doCreateByThirdIdTest() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("lizhaojing");
        userInfo.setUserThirdId("11112231");
        userInfo.setUserCreateTime("createtime");
        userInfo.setUserHeadImageURL("headurl");
        userDAOImpl.setConnection(dataBaseConnection.getConnection());

        boolean success = userDAOImpl.doCreateByThirdId(userInfo);
        System.out.println(success);
    }

    //@Test
    public void doSelectByPhoneTest() throws Exception {
        userDAOImpl.setConnection(dataBaseConnection.getConnection());
        UserInfo userInfo = userDAOImpl.doSelectByPhone("21521123");
        if (userInfo != null)
            System.out.println(userInfo.toString());
        else
            System.out.println("null");
    }
    @Test
    public void doSelectByThirdId() throws Exception {
        userDAOImpl.setConnection(dataBaseConnection.getConnection());
        UserInfo userInfo = userDAOImpl.doSelectByThirdId("11112231");
        if (userInfo != null)
            System.out.println(userInfo.toString());
        else
            System.out.println("null");
    }
}
