package com.hwcao.iot.service;

import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;

public interface RecordService {
    Result addRecord(RecordRqeDTO recordRqeDTO);
    Result delRecord(Long id);
}
