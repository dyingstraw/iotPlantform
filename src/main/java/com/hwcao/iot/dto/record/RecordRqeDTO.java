package com.hwcao.iot.dto.record;

import lombok.Data;

@Data
public class RecordRqeDTO {
    private Long deviceId;
    private String deviceValues;
    private Integer version;
}
