package com.hwcao.iot.service;

import com.hwcao.iot.entity.Result;
import org.springframework.stereotype.Component;

public interface RedisCacheService  {
    Result sync(String id);
}
