package com.hwcao.iot.entity.record;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hwcao.iot.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("t_record")
public class Record extends BaseEntity {
    private Long deviceId;
    private String deviceValues;
    private Integer version;

}
