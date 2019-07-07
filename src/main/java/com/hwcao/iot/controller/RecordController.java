package com.hwcao.iot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwcao.iot.dto.record.RecordRqeDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/list")
    public Result listRecord(RecordRqeDTO recordRqeDTO) {

        recordService.listRecord(recordRqeDTO);
        return null;
    }

}
