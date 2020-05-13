package com.chk.RabbitMQTest.config;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.chk.RabbitMQTest.constant.QueueConstant.ROUTING_KEY_DLX;
import static com.chk.RabbitMQTest.constant.QueueConstant.ROUTING_KEY_DLX_REDIRECT;


@Configuration
public class DlxRabbitConfig {

    @Bean
    DirectExchange dlxExchange() {
        return new DirectExchange(QueueConstant.EXCHANGE_DLX,true,false);
    }
    
    @Bean
    DirectExchange delayExchange() {
    	 return new DirectExchange(QueueConstant.EXCHANGE_DELAY,true,false);
    }

    @Bean
    Queue delayQueue() {
        Map<String,Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange",QueueConstant.EXCHANGE_DLX);
        args.put("x-dead-letter-routing-key",QueueConstant.ROUTING_KEY_DLX);
        args.put("x-message-ttl", 10000);
        return new Queue(QueueConstant.QUEUE_DLX_DEALY,true,false,false,args);
    }
    
    @Bean
    Queue delayQueue2() {
        Map<String,Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange",QueueConstant.EXCHANGE_DLX);
        args.put("x-dead-letter-routing-key",QueueConstant.ROUTING_KEY_DLX_2);
        args.put("x-message-ttl", 10000);
        return new Queue(QueueConstant.QUEUE_DLX_DEALY_2,true,false,false,args);
    }
    
    @Bean
    Queue dlxQueue() {
    	return new Queue(QueueConstant.QUEUE_DLX,true);
    }
    
    @Bean
    Queue dlxQueue2() {
    	return new Queue(QueueConstant.QUEUE_DLX_2,true);
    }

    @Bean
    Binding delayQueueBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(QueueConstant.ROUTING_KEY_DLX_DELAY);
    }
    
    @Bean
    Binding delay2QueueBinding() {
        return BindingBuilder.bind(delayQueue2()).to(delayExchange()).with(QueueConstant.ROUTING_KEY_DLX_DELAY_2);
    }

    @Bean
    Binding dlxQueueBinding() {
        return BindingBuilder.bind(dlxQueue()).to(dlxExchange()).with(QueueConstant.ROUTING_KEY_DLX);
    }
    
    @Bean
    Binding dlx2QueueBinding() {
        return BindingBuilder.bind(dlxQueue2()).to(dlxExchange()).with(QueueConstant.ROUTING_KEY_DLX_2);
    }

}
