package com.hwcao.iot.controller;

import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.RedisCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
@Slf4j
@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping("/cache/sync")
    public Result syncDataBase(@RequestParam("id") String id){
        try {
            redisCacheService.sync(id);
        }catch (Exception e){
            log.info("同步失败"+e);
        }
        return Result.SUCCESS();
    }

}
