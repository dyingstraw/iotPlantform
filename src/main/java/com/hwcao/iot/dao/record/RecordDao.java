package com.hwcao.iot.dao.record;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.dao.BaseDao;
import com.hwcao.iot.dao.mapper.RecordMapper;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.record.Record;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecordDao extends BaseDao<RecordMapper, Record> {
    @Autowired
    RecordMapper mapper;

    /**
     * 分页获取记录
     * @param page
     * @param recordRqeDTO
     * @return
     */
    public IPage<RecordRespDTO> getRecordByUserIdAndTime(Page page, RecordRqeDTO recordRqeDTO){
       return mapper.getRecordByUserIdAndTime(page,recordRqeDTO);
    }

    /**
     * 获取总数
     * @param recordRqeDTO
     * @return
     */
    public int countRecordByUserIdAndTime(RecordRqeDTO recordRqeDTO){
        return mapper.countRecordByUserIdAndTime(recordRqeDTO);
    }

}
