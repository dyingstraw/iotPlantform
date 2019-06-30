package com.hwcao.iot.service.impl;

import com.hwcao.iot.service.RedisCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheServiceImplTest {
    @Autowired
    private RedisCacheService redisCacheService;

    @Test
    public void sync() {
        redisCacheService.sync("");
    }
}