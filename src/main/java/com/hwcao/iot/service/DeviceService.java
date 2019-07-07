package com.hwcao.iot.service;

import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DeviceService {

    Result addDevice(DeviceReqDTO deviceReqDTO);

    Result<Device> findOne(Long id);

    Result<Device> updateDevice(DeviceReqDTO deviceReqDTO);

    Result deleteDevice(Long id);

    Result<List<Device>> findAllByUser(Long userId);

    void excelDownload(Long userId,Result<List<Device>> res, HttpServletResponse response) throws Exception;
}
