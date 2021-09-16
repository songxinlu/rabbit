package com.example.mqtt.config.work;

import com.example.mqtt.message.work.WorkReceiver;
import com.example.mqtt.message.work.WorkSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:工作模式，一个生产者、多个消费者
 * @Author songxl
 * @Date 2021/9/15
 */
@Configuration
public class WorkRabbitConfig {
    @Bean
    public Queue workQueue(){
        return new Queue("work");
    }
    @Bean
    public WorkSender workSender(){
        return new WorkSender();
    }
    @Bean
    public WorkReceiver workReceiver1(){
        return new WorkReceiver(1);
    }
    @Bean
    public WorkReceiver workReceiver2(){
        return new WorkReceiver(2);
    }

}
