package com.example.mqtt.config.fanout;

import com.example.mqtt.message.fanout.FanoutReceiver;
import com.example.mqtt.message.fanout.FanoutSender;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:发布/订阅模式配置类
 * @Author songxl
 * @Date 2021/9/15
 */
@Configuration
public class FanoutRabbitConfig {
    //创建一个交换机、一个生产者、两个队列、两个消费者
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange("exchange.test");
    }
    @Bean
    public FanoutSender  fanoutSender(){
        return new FanoutSender();
    }
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout2");
    }
    //队列绑定交换机
    @Bean
    public Binding fanoutBinding1(FanoutExchange exchange,  Queue fanoutQueue1){
        return BindingBuilder.bind(fanoutQueue1).to(exchange);
    }
    @Bean
    public Binding fanoutBinding2(FanoutExchange exchange,  Queue fanoutQueue2){
        return BindingBuilder.bind(fanoutQueue2).to(exchange);
    }
    @Bean
    public FanoutReceiver fanoutReceiver(){
        return new FanoutReceiver();
    }
}
