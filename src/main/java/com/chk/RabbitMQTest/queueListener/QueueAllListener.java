package com.chk.RabbitMQTest.queueListener;

import com.chk.RabbitMQTest.constant.QueueConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = QueueConstant.QUEUE_ALL)
public class QueueAllListener {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Queue ALL Handle Message:"+msg);
    }

}
