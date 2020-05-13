package com.chk.RabbitMQTest.config;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    @Bean
    Queue fanoutQueueOne() {
        return new Queue(QueueConstant.QUEUE_FANOUT_ONE,true);
    }

    @Bean
    Queue fanoutQueueTwo() {
        return new Queue(QueueConstant.QUEUE_FANOUT_TWO,true);
    }

    @Bean
    Queue fanoutQueueThree() {
        return new Queue(QueueConstant.QUEUE_FANOUT_THREE,true);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(QueueConstant.EXCHANGE_FANOUT,true,false);
    }

    @Bean
    Binding bindQueueOne() {
        return BindingBuilder.bind(fanoutQueueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindQueueTwo() {
        return BindingBuilder.bind(fanoutQueueTwo()).to(fanoutExchange());
    }

    @Bean
    Binding bindQueueThree() {
        return BindingBuilder.bind(fanoutQueueThree()).to(fanoutExchange());
    }

}
