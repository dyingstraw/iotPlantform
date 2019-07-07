package com.hwcao.iot.controller;

import com.hwcao.iot.dto.device.DeviceExcelDTO;
import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.service.DeviceService;
import com.hwcao.iot.util.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

    /**
     * Excel表格导出接口
     * http://localhost:8080/ExcelDownload
     * @param response response对象
     * @throws IOException 抛IO异常
     */
    @GetMapping("/list/export")
    public void excelDownload(@RequestParam("userId") Long userId ,HttpServletResponse response) throws Exception {

        List<List<String>> excelData = new ArrayList<>();

        //查询数据
        Result<List<Device>> res = deviceService.findAllByUser(userId);
        //数据下载
        deviceService.excelDownload(userId,res,response);
    }


}
