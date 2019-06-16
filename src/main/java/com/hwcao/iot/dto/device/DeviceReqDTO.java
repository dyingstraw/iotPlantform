package com.hwcao.iot.dto.device;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceReqDTO {
    private String desc;
    private String name;
}
