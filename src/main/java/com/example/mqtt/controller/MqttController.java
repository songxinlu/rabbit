package com.example.mqtt.controller;

import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.gateway.MqttGateway;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MQTT测试接口
 * Created by macro on 2020/9/15.
 */
@Api(tags = "MqttController", value = "MQTT测试接口")
@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttGateway mqttGateway;

    @PostMapping("/sendToDefaultTopic")
    @ApiOperation("向默认主题发送消息")
    public CommonResult sendToDefaultTopic(String payload) {
        mqttGateway.sendToMqtt(payload);
        return CommonResult.success(null);
    }

    @PostMapping("/sendToTopic")
    @ApiOperation("向指定主题发送消息")
    public CommonResult sendToTopic(String payload, String topic) {
        mqttGateway.sendToMqtt(payload, topic);
        return CommonResult.success(null);
    }
}
