package com.example.mqtt.controller;

import com.example.mqtt.common.api.CommonResult;
import com.example.mqtt.message.work.WorkSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:工作模式
 * @Author songxl
 * @Date 2021/9/15
 */
@Api(tags = "WorkController", value = "工作模式测试")
@RestController
@RequestMapping("/rabbit")
public class WorkController {
    @Autowired
    private WorkSender workSender;

    @ApiOperation("工作模式")
    @GetMapping("/work")
    public CommonResult work(){
        for(int i=0;i<10;i++){
            workSender.send(i);
        }
        return CommonResult.success(true);
    }

}
