package com.hwcao.iot.dto.record;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.Date;

@Data
public class RecordRqeDTO{
    private Long userId;
    private Long deviceId;
    private String deviceValues;
    private Integer version;
    private String dateStart;
    private String dateEnd;
    private Integer size;
    private Integer current;

}
