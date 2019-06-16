package com.hwcao.iot.dao.device;

import com.hwcao.iot.dao.BaseDao;
import com.hwcao.iot.dao.mapper.DeviceMapper;
import com.hwcao.iot.entity.device.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceDao extends BaseDao<DeviceMapper, Device> {
}
