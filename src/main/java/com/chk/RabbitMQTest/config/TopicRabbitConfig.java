package com.chk.RabbitMQTest.config;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

    @Bean
    Queue queueMan() {
        return new Queue(QueueConstant.QUEUE_MAN);
    }

    @Bean
    Queue queueWoman() {
        return new Queue(QueueConstant.QUEUE_WOMAN);
    }

    @Bean
    Queue queueAll() {
        return new Queue(QueueConstant.QUEUE_ALL);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(QueueConstant.EXCHANGE_TOPIC,true,false);
    }

    @Bean
    Binding bindingTopicMan() {
        return BindingBuilder.bind(queueMan()).to(topicExchange()).with(QueueConstant.TOPIC_MAN);
    }

    @Bean
    Binding bindingTopicWoman() {
        return BindingBuilder.bind(queueWoman()).to(topicExchange()).with(QueueConstant.TOPIC_WOMAN);
    }

    @Bean
    Binding bindingTopicAll() {
        return BindingBuilder.bind(queueAll()).to(topicExchange()).with(QueueConstant.TOPIC_ALL);
    }

}
