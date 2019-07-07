package com.hwcao.iot.dto.device;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceExcelDTO {
    private Long id;
    private Date createTime;
    private Long createUser;
    private Date updateTime;
    private Long updateUser;
    private Integer delFlag;
    private String deviceName;
    private String secretKey;
    private String deviceDesc;
    private Long userId;
    private Integer version;
}
