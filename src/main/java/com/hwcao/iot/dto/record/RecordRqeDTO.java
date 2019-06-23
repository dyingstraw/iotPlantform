package com.hwcao.iot.dto.record;

import lombok.Data;

@Data
public class RecordRqeDTO {
    private Long devId;
    private String values;
    private Integer version;
}
