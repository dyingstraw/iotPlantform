package com.hwcao.iot.dto.record;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class RecordRespDTO {
    private Long userId;
    private Long deviceId;
    private String deviceName;
    private String deviceValues;
    private String createTime;
}
