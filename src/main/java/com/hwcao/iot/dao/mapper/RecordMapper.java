package com.hwcao.iot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hwcao.iot.entity.record.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
