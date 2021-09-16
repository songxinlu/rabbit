package com.example.mqtt.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.message.fanout.FanoutSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:发布/订阅模式
 * @Author songxl
 * @Date 2021/9/15
 */
@Api(tags = "FanoutController",value = "发布/订阅模式")
@RestController
@RequestMapping("/rabbit")
public class FanoutController {
    @Autowired
    private FanoutSender fanoutSender;

    @ApiOperation("发布/订阅模式")
    @GetMapping("/fanout")
    public CommonResult fanoutTest() {
        for(int i=0;i<10;i++){
            fanoutSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }

}
