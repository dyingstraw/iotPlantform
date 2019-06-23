package com.hwcao.iot.dao.record;

import com.hwcao.iot.dao.BaseDao;
import com.hwcao.iot.dao.mapper.RecordMapper;
import com.hwcao.iot.entity.record.Record;
import org.springframework.stereotype.Component;

@Component
public class RecordDao extends BaseDao<RecordMapper, Record> {
}
