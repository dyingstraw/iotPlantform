package com.hwcao.iot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.record.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RecordMapper extends BaseMapper<Record> {


    @Select(" " +
            " SELECT r.id as id,r.device_values as device_values,d.device_name as device_name,d.user_id as user_id " +
            " FROM t_record r JOIN t_devices d " +
            " on r.device_id = #{recordRqeDTO.deviceId} and user_id = #{recordRqeDTO.userId}"
             )
    public Page<RecordRespDTO> getRecordByUserIdAndTime(IPage page, RecordRqeDTO recordRqeDTO);

}
