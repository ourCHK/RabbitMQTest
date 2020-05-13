package com.chk.RabbitMQTest.queueListener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Component
public class QueueAckReceiver implements ChannelAwareMessageListener {

	private final static int MAX_TRY_COUNT = 3;
	
	private final static int SLEEP_TIME = 5000;	//休眠30秒
	
	int maxTry;
	
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        System.out.println("消费队列："+message.getMessageProperties().getConsumerQueue());
//        channel.basicAck(deliveryTag,false);
//        channel.basicReject(deliveryTag,true);
//        channel.basicNack(deliveryTag,false,true);
//        channel.basicReject(deliveryTag,true);
        System.out.println("准备消费队列1："+message.getMessageProperties().getConsumerQueue());
        if (maxTry ++ >= MAX_TRY_COUNT) {
        	System.out.println("消费已达最大次数，队列消费失败！");
        	channel.basicNack(deliveryTag, false, true);
        	maxTry = 0;
        	Thread.sleep(SLEEP_TIME);
        } else {
        	System.out.println("队列消费成功："+new String(message.getBody(), "UTF-8"));
        	channel.basicAck(deliveryTag, false);
        }
    }



}
