package com.hwcao.iot.controller;

import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    /** * 添加设备*/
    @PostMapping("")
    public Result addDevice(DeviceReqDTO deviceReqDTO){
        return deviceService.addDevice(deviceReqDTO);
    }

    /**查询设备*/
    @GetMapping
    public Result<Device> findOne(@RequestParam("id") Long id){
        return deviceService.findOne(id);
    }

    @PutMapping("")
    public Result<Device> updateDevice(DeviceReqDTO deviceReqDTO){
        return deviceService.updateDevice(deviceReqDTO);
    }

    @DeleteMapping("")
    public Result deleteDevice(@RequestParam("id") Long id){
        return deviceService.deleteDevice(id);
    }

    @GetMapping("/list")
    public Result<List<Device>> findAllByUser(@RequestParam("userId") Long userId ){
        return deviceService.findAllByUser(userId);
    }
}
