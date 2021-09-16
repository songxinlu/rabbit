package com.example.mqtt.message.fanout;

import cn.hutool.core.thread.ThreadUtil;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;
import org.slf4j.Logger;
/**
 * @Description:发布订阅模式接收者
 * @Author songxl
 * @Date 2021/9/15
 */
public class FanoutReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutReceiver.class);
    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receive1(String in) {
        receive(in, 1);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receive2(String in) {
        receive(in, 2);
    }

    private void receive(String in, int receiver) {
        StopWatch watch = new StopWatch();
        watch.start();
        LOGGER.info("instance {} [x] Received '{}'", receiver, in);
        doWork(in);
        watch.stop();
        LOGGER.info("instance {} [x] Done in {}s", receiver, watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                ThreadUtil.sleep(1000);
            }
        }
    }


}
