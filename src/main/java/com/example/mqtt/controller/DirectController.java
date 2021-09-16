package com.example.mqtt.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.message.direct.DirectSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:路由模式
 * @Author songxl
 * @Date 2021/9/15
 */
@Api(tags = "DirectController",value = "路由模式")
@RestController
@RequestMapping("/rabbit")
public class DirectController {
    @Autowired
    private DirectSender directSender;
    @ApiOperation("路由模式")
    @GetMapping("/direct")
    public CommonResult directTest() {
        for(int i=0;i<10;i++){
            directSender.send(i);
            ThreadUtil.sleep(1000);
        }
        return CommonResult.success(null);
    }
}
