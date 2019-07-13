package com.hwcao.iot.dto.device;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceReqDTO {
    private Long id;
    private String deviceDesc;
    private String deviceName;
}
