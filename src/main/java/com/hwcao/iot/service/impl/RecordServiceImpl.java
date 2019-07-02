package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.Enum.ResultEnum;
import com.hwcao.iot.dao.record.RecordDao;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.record.Record;
import com.hwcao.iot.exception.ServiceException;
import com.hwcao.iot.service.RecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public Result addRecord(RecordRqeDTO recordRqeDTO) {
        try {
            Record record = new Record();
            BeanUtils.copyProperties(recordRqeDTO, record);
            recordDao.add(record);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(ResultEnum.RECORD_ADD_ERROR);
        }
        return Result.SUCCESS();
    }

    @Override
    public Result delRecord(Long id) {
        try {
            recordDao.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(ResultEnum.RECORD_DEL_ERROR);
        }
        return Result.SUCCESS();
    }

//    @Override
//    public List<Record> listRecord(Date dateStart, Date dateEnd) {
//        List<Record> result  = new ArrayList<>();
//        try{
//            QueryWrapper wq = new QueryWrapper();
//            wq.ge("create_time",dateStart);
//            wq.le("create_time",dateEnd);
//
//            result = recordDao.getList(wq);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

    @Override
    public Result<IPage<RecordRespDTO>> listRecord(RecordRqeDTO recordRqeDTO) {
        IPage<RecordRespDTO> result = recordDao.getRecordByUserIdAndTime(new Page(recordRqeDTO.getCurrent(), recordRqeDTO.getSize()), recordRqeDTO);
        return Result.SUCCESS(result);
    }
}
