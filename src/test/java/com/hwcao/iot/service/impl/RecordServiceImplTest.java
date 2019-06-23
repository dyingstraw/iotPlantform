package com.hwcao.iot.service.impl;

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
        recordRqeDTO.setDevId(123456L);
        recordRqeDTO.setValues("{“value1”:0.1,“value2”:2.3}");
        recordRqeDTO.setVersion(1);
        Result result = recordService.addRecord(recordRqeDTO);
        Assert.assertEquals(result.getCode(),new Integer(200));
    }

    @Test
    public void delRecord() {
        Result result = recordService.delRecord(1L);
        Assert.assertEquals(result.getCode(),new Integer(200));

    }
}