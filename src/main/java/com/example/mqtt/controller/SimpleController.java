package com.example.mqtt.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.message.simple.SimpleSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:简单模式
 * @Author songxl
 * @Date 2021/9/14
 */
@Api(tags = "SimpleController", value = "RabbitMQ功能测试")
@RestController
@RequestMapping("/rabbit")
public class SimpleController {
    @Autowired
    private SimpleSender simpleSender;

    @ApiOperation("简单模式")
    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult simpleTest() {
        for(int i=0;i<10;i++){
            simpleSender.send();
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }
}
