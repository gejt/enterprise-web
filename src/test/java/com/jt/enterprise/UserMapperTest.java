package com.jt.enterprise;

import com.jt.common.enums.UserSexEnum;
import com.jt.enterprise.domain.Users;
import com.jt.enterprise.mapper.UserMapper;
import com.jt.enterprise.service.UserService;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper UserDao;
    @Resource
    UserService userService;

    @Test
    public void testInsert() throws Exception {
    	userService.register(new Users("gejt1", "a123456", UserSexEnum.MAN));
    	userService.register(new Users("gejt2", "b123456", UserSexEnum.MAN));
    	userService.register(new Users("gejt3", "b123456", UserSexEnum.MAN));
    }

    @Test
    public void testQuery() throws Exception {
    	Users users = UserDao.getOne(1l);
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        Users user = UserDao.getOne(3l);
        System.out.println(user.toString());
        user.setNickName("neo");
        UserDao.update(user);
    }
}