package com.chk.RabbitMQTest.config;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue TestDirectQueue() {
        return new Queue(QueueConstant.QUEUE_DIRECT,true);
    }


    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange(QueueConstant.EXCHANGE_DIRECT,true,false);
    }

    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with(QueueConstant.ROUTING_KEY_DIRECT);
    }



}
