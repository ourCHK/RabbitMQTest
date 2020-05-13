package com.chk.RabbitMQTest.queueListener;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = QueueConstant.QUEUE_WOMAN)
public class QueueWomanListener {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Queue woman Handle Message:"+msg);
    }

}
