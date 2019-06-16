package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwcao.iot.Enum.ResultEnum;
import com.hwcao.iot.dao.device.DeviceDao;
import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.exception.CustomException;
import com.hwcao.iot.exception.DeviceException;
import com.hwcao.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Override
    //回滚操作
    @Transactional(rollbackForClassName = "Exception.class")
    public Result addDevice(DeviceReqDTO deviceReqDTO) {
        Device device = new Device();
        device.setDeviceName(deviceReqDTO.getName());
        device.setDeviceDesc(deviceReqDTO.getDesc());
        String deviceKey = UUID.randomUUID().toString();
        device.setSecretKey(deviceKey);
        deviceDao.add(device);
        return Result.SUCCESS();
    }

    @Override
    public Result<Device> findOne(Long id) {
        Device device = deviceDao.getOneById(id);
        return Result.SUCCESS(device);
    }

    @Override
    public Result<Device> updateDevice(DeviceReqDTO deviceReqDTO) {
        Device device = null;
        try{
            device = deviceDao.getOneById(deviceReqDTO.getId());
            device.setDeviceName(deviceReqDTO.getName());
            device.setDeviceDesc(deviceReqDTO.getDesc());
        }catch (Exception e){
            throw new DeviceException(ResultEnum.DEVICE_NOT_FIND);
        }

        return Result.SUCCESS(device);
    }

    @Override
    public Result deleteDevice(Long id) {
        Device device = null;
        try{
            device = deviceDao.getOneById(id);
            device.setDelFlag(1);
            deviceDao.update(device);
        }catch (Exception e){
            throw new DeviceException(ResultEnum.DEVICE_NOT_FIND);
        }

        return Result.SUCCESS();
    }

    @Override
    public Result<List<Device>> findAllByUser(Long userId) {
        List<Device> deviceList = null;
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",userId);
        deviceList = deviceDao.getList(wrapper);
        return Result.SUCCESS(deviceList);
    }
}
