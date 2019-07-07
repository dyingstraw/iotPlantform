package com.hwcao.iot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.record.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    /**
     * 历史记录通过用户查找的Mapper
     * @param page
     * @param recordRqeDTO
     * @return
     */
    @Select(
            "<script> " +
                "SELECT r.id as device_id,r.device_values as device_values,d.device_name as device_name,d.user_id as user_id,r.create_time as create_time "+
                    "FROM t_record r JOIN t_devices d on r.device_id = d.id "+
                    "<where>"+
                        "<if test='recordRqeDTO.userId != null'>"+
                            " user_id = #{recordRqeDTO.userId} "+
                        "</if>"+
                        "<if test='recordRqeDTO.deviceId != null'>"+
                            " and device_id = #{recordRqeDTO.deviceId} "+
                        "</if>"+
                        "<if test='recordRqeDTO.dateStart != null and recordRqeDTO.dateEnd != null'>"+
                            " and r.create_time BETWEEN #{recordRqeDTO.dateStart} AND #{recordRqeDTO.dateEnd}  "+
                        "</if>"+

                    "</where> " +
            "</script>"
             )
    /**
     * " SELECT r.id as device_id,r.device_values as device_values,d.device_name as device_name,d.user_id as user_id " +
     *             " FROM t_record r JOIN t_devices d " +
     *             " on r.device_id = d.id and user_id = #{recordRqeDTO.userId}"
     */
    Page<RecordRespDTO> getRecordByUserIdAndTime(Page page, @Param("recordRqeDTO")RecordRqeDTO recordRqeDTO);

}
