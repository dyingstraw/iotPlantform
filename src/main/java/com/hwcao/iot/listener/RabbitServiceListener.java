package com.hwcao.iot.listener;

import com.alibaba.fastjson.JSONObject;
import com.hwcao.iot.entity.record.Record;
import com.hwcao.iot.service.RecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class RabbitServiceListener {
    @Autowired
    private RecordService recordService;
    /**
     * 消息消费
     *
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitListener(queues = "hello", containerFactory = "rabbitListenerContainerFactory")
    @RabbitHandler
    public void recieved(byte[] msg) throws Exception {
        String inputString = new String(msg);
        log.info("[hello] recieved message:" + inputString);
        JSONObject jsonMsg = (JSONObject) JSONObject.parse(new String(inputString));
        Record record = new Record();
        record.setDeviceId(jsonMsg.getLong("devId"));
        // {"createTime":1562078440060,"createUser":1,"devId":1,"values":[0.1,0.2]}
        record.setDeviceValues(jsonMsg.getJSONArray("values").get(0) + "," + jsonMsg.getJSONArray("values").get(1));
        record.setVersion(1);
        recordService.addRecord(record);


    }
}
