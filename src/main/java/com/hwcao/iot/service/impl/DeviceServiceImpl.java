package com.hwcao.iot.service.impl;

import com.hwcao.iot.dao.device.DeviceDao;
import com.hwcao.iot.dao.mapper.DeviceMapper;
import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    //回滚操作
    @Transactional(rollbackForClassName = "Exception.class")
    public Result addDevice(DeviceReqDTO deviceReqDTO) {
        Device device = new Device();
        device.setDeviceName(deviceReqDTO.getName());
        device.setDeviceDesc(deviceReqDTO.getDesc());
        String deviceKey = UUID.randomUUID().toString();
        device.setSecretKey(deviceKey);
        // deviceMapper.insert(device);
        deviceDao.add(device);
        return Result.SUCCESS();
    }
}
