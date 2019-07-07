package com.hwcao.iot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.record.Record;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface RecordService {
    Result addRecord(RecordRqeDTO recordRqeDTO);
    Result addRecord(Record record);
    Result delRecord(Long id);

    Result<IPage<RecordRespDTO>> listRecord(RecordRqeDTO recordRqeDTO);
}
