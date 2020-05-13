package com.chk.RabbitMQTest.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chk.RabbitMQTest.constant.QueueConstant;
import com.chk.RabbitMQTest.queueListener.QueueAckReceiver;
import com.chk.RabbitMQTest.queueListener.QueueAckReceiver2;

@Configuration
public class RabbitConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private QueueAckReceiver queueAckReceiver;
    
    @Autowired
    private QueueAckReceiver2 queueAckReceiver2;

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMandatory(true);

        template.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {      //消息已发送到交换机（应该就是提交到服务器）,一定会回调，不管成功与否
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("数据相关："+correlationData);
                System.out.println("确认情况："+b);
                System.out.println("原因："+s);
            }
        });

        template.setReturnCallback(new RabbitTemplate.ReturnCallback() {    //消息已经发送到客户端，应该就是发送到消费者。只有发送到队列时出异常时才回调，注意，前提是提交到服务器正常时，才会去发送到队列
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                System.out.println("ReturnCallback:     "+"消息："+message);
                System.out.println("ReturnCallback:     "+"回应码："+i);
                System.out.println("ReturnCallback:     "+"回应信息："+s);
                System.out.println("ReturnCallback:     "+"交换机："+s1);
                System.out.println("ReturnCallback:     "+"路由键："+s2);
            }
        });
        return template;
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(2);
        container.setMaxConcurrentConsumers(2);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setQueueNames(QueueConstant.QUEUE_DLX);
//        container.addQueueNames(QueueConstant.QUEUE_DLX_2);
        container.setMessageListener(queueAckReceiver);
        return container;
    }
    
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer2() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(2);
        container.setMaxConcurrentConsumers(2);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setQueueNames(QueueConstant.QUEUE_DLX);
        container.addQueueNames(QueueConstant.QUEUE_DLX_2);
        container.setMessageListener(queueAckReceiver2);
        return container;
    }


}
