package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hwcao.iot.dto.record.RecordRespDTO;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.record.Record;
import com.hwcao.iot.service.RecordService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecordServiceImplTest {
    @Autowired
    private RecordService recordService;

    @Test
    public void addRecord() {
        RecordRqeDTO recordRqeDTO = new RecordRqeDTO();
        recordRqeDTO.setDeviceId(123456L);
        recordRqeDTO.setDeviceValues("{\"value1\":0.1,\"value2\":2.3}");
        recordRqeDTO.setVersion(1);
        Result result = recordService.addRecord(recordRqeDTO);
        Assert.assertEquals(result.getCode(),new Integer(200));
    }

    @Test
    public void delRecord() {
        Result result = recordService.delRecord(1L);
        Assert.assertEquals(result.getCode(),new Integer(200));

    }

    @Test
    public void getPage() throws ParseException {
        RecordRqeDTO recordRqeDTO = new RecordRqeDTO();
        recordRqeDTO.setDeviceId(1L) ;
        recordRqeDTO.setUserId(1L);
        recordRqeDTO.setDateStart("2019-06-01");
        recordRqeDTO.setDateEnd("2019-07-01");
        Result<IPage<RecordRespDTO>> res = recordService.listRecord(recordRqeDTO);
        System.out.println(res.getData().getRecords());
    }
}