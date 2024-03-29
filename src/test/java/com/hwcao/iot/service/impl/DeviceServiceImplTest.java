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


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceServiceImplTest {
    @Autowired
    private  DeviceService deviceService;

    @Test
    public void addDevice() {
        DeviceReqDTO deviceReqDTO = new DeviceReqDTO(9L,"设备2","dev2");
        Result result = deviceService.addDevice(deviceReqDTO);
        Assert.assertEquals(new Integer(200),result.getCode());
    }
    @Test
    public void updateDevice(){
        DeviceReqDTO deviceReqDTO = new DeviceReqDTO(2L,"设备2","dev2");
        deviceService.updateDevice(deviceReqDTO);
    }
}