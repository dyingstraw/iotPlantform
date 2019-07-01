package com.hwcao.iot.dto.record;

import lombok.Data;

import java.util.List;

@Data
public class RecordRespDTO {
    private Long deviceId;
    private String deviceName;
    private List<Double> deviceValues;
}
