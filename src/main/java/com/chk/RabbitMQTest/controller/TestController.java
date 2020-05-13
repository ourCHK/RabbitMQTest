package com.chk.RabbitMQTest.controller;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/hello")
    String hello() {
        return "Hello";
    }

    @RequestMapping("/sendMessage")
    String sendMessage(String exchange,String routingKey,String msg) {
        rabbitTemplate.convertAndSend(exchange,routingKey,msg);
        return "OK";
    }

    @RequestMapping("/topic")
    String sendTopicMessage(String topic) {
        String msg = "topicMessage";
        rabbitTemplate.convertAndSend(QueueConstant.EXCHANGE_TOPIC,topic,msg);
        return "OK";
    }

    @RequestMapping("/fanout")
    String sendFanoutMessage(String topic) {
        rabbitTemplate.convertAndSend(QueueConstant.EXCHANGE_FANOUT,null,"message");
        return "pl";
    }

}
