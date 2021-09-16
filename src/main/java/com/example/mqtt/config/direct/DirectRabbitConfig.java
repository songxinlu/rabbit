package com.example.mqtt.config.direct;

import com.example.mqtt.message.direct.DirectReceiver;
import com.example.mqtt.message.direct.DirectSender;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:路由模式
 * @Author songxl
 * @Date 2021/9/15
 */
@Configuration
public class DirectRabbitConfig {
    //创建一个交换机、两个队列、生产者、消费者
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("exchange.direct");
    }

    @Bean
    public Queue directQueue1() {
        return new Queue("direct1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("direct2");
    }
    @Bean
    public Queue directQueue3() {
        return new Queue("direct3");
    }

    @Bean
    public DirectReceiver receiver() {
        return new DirectReceiver();
    }


    @Bean
    public DirectSender directSender() {
        return new DirectSender();
    }

    //交换机绑定路由、队列
    @Bean
    public Binding directBinding1(DirectExchange direct, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(direct).with("orange");
    }

    @Bean
    public Binding directBinding2(DirectExchange direct, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(direct).with("black");
    }

    @Bean
    public Binding directBinding3(DirectExchange direct, Queue directQueue3) {
        return BindingBuilder.bind(directQueue3).to(direct).with("green");
    }

}
