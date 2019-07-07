package com.hwcao.iot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hwcao.iot.Enum.ResultEnum;
import com.hwcao.iot.dao.device.DeviceDao;
import com.hwcao.iot.dao.mapper.DeviceMapper;
import com.hwcao.iot.dto.device.DeviceExcelDTO;
import com.hwcao.iot.dto.device.DeviceReqDTO;
import com.hwcao.iot.entity.Result;
import com.hwcao.iot.entity.device.Device;
import com.hwcao.iot.exception.CustomException;
import com.hwcao.iot.exception.DeviceException;
import com.hwcao.iot.service.DeviceService;
import com.hwcao.iot.util.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao deviceDao;
    @Autowired
    private DeviceMapper deviceMapper;
    @Override
    //回滚操作
    @Transactional(rollbackForClassName = "Exception.class")
    public Result addDevice(DeviceReqDTO deviceReqDTO) {
        Device device = new Device();
        device.setDeviceName(deviceReqDTO.getName());
        device.setDeviceDesc(deviceReqDTO.getDesc());
        String deviceKey = UUID.randomUUID().toString();
        device.setSecretKey(deviceKey);
        // deviceMapper.insert(device);
        deviceDao.add(device);
        return Result.SUCCESS();
    }

    @Override
    public Result<Device> findOne(Long id) {
        Device device = deviceDao.getOneById(id);
        return Result.SUCCESS(device);
    }

    @Override
    public Result<Device> updateDevice(DeviceReqDTO deviceReqDTO) {
        Device device = null;
        try{
            device = deviceDao.getOneById(deviceReqDTO.getId());
            device.setDeviceName(deviceReqDTO.getName());
            device.setDeviceDesc(deviceReqDTO.getDesc());
        }catch (Exception e){
            throw new DeviceException(ResultEnum.DEVICE_NOT_FIND);
        }

        return Result.SUCCESS(device);
    }

    @Override
    public Result deleteDevice(Long id) {
        Device device = null;
        try{
            device = deviceDao.getOneById(id);
            device.setDelFlag(1);
            deviceDao.update(device);
        }catch (Exception e){
            throw new DeviceException(ResultEnum.DEVICE_NOT_FIND);
        }

        return Result.SUCCESS();
    }

    @Override
    public Result<List<Device>> findAllByUser(Long userId) {
        List<Device> deviceList = null;
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id",userId);
        deviceList = deviceDao.getList(wrapper);
        return Result.SUCCESS(deviceList);
    }

    @Override
    public void excelDownload(Long userId,Result<List<Device>> res, HttpServletResponse response) throws Exception {
        List<List<String>> excelData = new ArrayList<>();
        //获取数据的列名
        Class clazz = Class.forName("com.hwcao.iot.dto.device.DeviceExcelDTO");
        Field[] fields = clazz.getDeclaredFields();
        List<String> head = new ArrayList<>();
        for(Field field:fields){
            head.add(field.getName());
        }
        excelData.add(head);
        //数据中的data取出
        List<Device> deviceList = res.getData();
        List<DeviceExcelDTO> deviceExcelDTOList = new ArrayList<>();

        for (int i = 0; i <deviceList.size() ; i++) {
            DeviceExcelDTO deviceExcelDTO = new DeviceExcelDTO();
            BeanUtils.copyProperties(deviceList.get(i),deviceExcelDTO);
            deviceExcelDTOList.add(deviceExcelDTO);
        }

        for(int i=0;i<deviceExcelDTOList.size();i++){
            List<String> rowData = new ArrayList<>();
            for (String h:head){
                Field t = clazz.getDeclaredField(h);
                t.setAccessible(true);
                String cellData = String.valueOf(t.get(deviceExcelDTOList.get(i)));
                rowData.add(cellData);
            }
            excelData.add(rowData);

        }

        String sheetName = "测试";
        String fileName = "ExcelTest.xls";

        ExcelUtil.exportExcel(sheetName,15,excelData,response,fileName);
    }
}
