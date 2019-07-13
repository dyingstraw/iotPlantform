package com.hwcao.iot.service.impl;

import com.hwcao.iot.entity.user.User;
import com.hwcao.iot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest extends ApplicationContextTestUtils {
    @Autowired
    UserService userService;

}