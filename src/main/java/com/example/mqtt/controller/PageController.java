package com.example.mqtt.controller;

import com.example.mqtt.config.mqtt.MqttConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by macro on 2020/9/16.
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    private MqttConfig mqttConfig;

    @GetMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.put("mqtt_url", mqttConfig.getMqtt_url());
        return "index";
    }
}
