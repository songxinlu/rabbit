package com.example.mqtt.controller;

import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.message.topic.TopicSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:通配符模式
 * @Author songxl
 * @Date 2021/9/15
 */
@Api(tags = "TopicController", value = "通配符模式测试")
@RestController
@RequestMapping("/rabbit")
public class TopicController {
    @Autowired
    private TopicSender topicSender;

    @ApiOperation("通配符模式")
    @GetMapping("/topic")
    public CommonResult work(){
        for(int i=0;i<10;i++){
            topicSender.send(i);
        }
        return CommonResult.success(true);
    }
}
