package com.hwcao.iot.service;

import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;

public interface DeviceService {

    Result addDevice(DeviceReqDTO deviceReqDTO);
}
