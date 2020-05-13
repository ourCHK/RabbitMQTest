package com.chk.RabbitMQTest.queueListener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

//@Component
//@RabbitListener(queues = QueueConstant.QUEUE_DIRECT)
public class DirectQueueListener {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("DirectQueue Handle Message:"+msg);
    }


}
