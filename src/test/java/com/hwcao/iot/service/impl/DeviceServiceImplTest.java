package com.hwcao.iot.service.impl;

import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.DeviceService;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceImplTest {
    @Autowired
    private  DeviceService deviceService;

    @Test
    public void addDevice() {
        DeviceReqDTO deviceReqDTO = new DeviceReqDTO(1L,"设备1","device1");
        Result result = deviceService.addDevice(deviceReqDTO);
        Assert.assertEquals(new Integer(200),result.getCode());
    }
}