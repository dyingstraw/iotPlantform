package com.hwcao.iot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwcao.iot.entity.device.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
}
