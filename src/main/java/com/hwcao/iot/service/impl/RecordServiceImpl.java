package com.hwcao.iot.service.impl;

import com.hwcao.iot.Enum.ResultEnum;
import com.hwcao.iot.dao.record.RecordDao;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.record.Record;
import com.hwcao.iot.exception.ServiceException;
import com.hwcao.iot.service.RecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;
    @Override
    public Result addRecord(RecordRqeDTO recordRqeDTO) {
        try {
            Record record = new Record();
            BeanUtils.copyProperties(recordRqeDTO,record);
//            record.setDeviceId(recordRqeDTO.getDeviceId());
//            record.setDeviceValues(recordRqeDTO.getDeviceValues());
//            record.setVersion(recordRqeDTO.getVersion());
            recordDao.add(record);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException(ResultEnum.RECORD_ADD_ERROR);
        }
        return Result.SUCCESS();
    }

    @Override
    public Result delRecord(Long id) {
        try {
            recordDao.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
            throw new ServiceException(ResultEnum.RECORD_DEL_ERROR);

        }
        return Result.SUCCESS();
    }
}
