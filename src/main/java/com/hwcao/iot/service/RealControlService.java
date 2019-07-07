package com.hwcao.iot.service;

import com.hwcao.iot.entity.Result;

/**
 * @program: iots_pringboot
 * @description: 实时显示控制服务
 * @author: dyingstraw
 * @create: 2019-07-07 21:50
 **/
public interface RealControlService {
    /**
     * 取消订阅
     * @return
     */
    Result<Boolean> cancelSubscribe();

    /**
     * 开始订阅
     * @return
     */
    Result<Boolean> startSubscribe();
}
