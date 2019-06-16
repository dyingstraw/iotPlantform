package com.hwcao.iot.entity.device;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hwcao.iot.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("t_devices")
public class Device extends BaseEntity {
    private String deviceName;
    private String secretKey;
    private String deviceDesc;
    private Long userId;
    private Integer version;
}
