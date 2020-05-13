package com.chk.RabbitMQTest.constant;

public class QueueConstant {

    public static final String QUEUE_DIRECT = "QUEUE_DIRECT";

    public static final String EXCHANGE_DIRECT  = "EXCHANGE_DIRECT";

    public static final String ROUTING_KEY_DIRECT = "ROUTING_KEY_DIRECT";


    public static final String QUEUE_MAN = "QUEUE_MAN";

    public static final String QUEUE_WOMAN = "QUEUE_WOMAN";

    public static final String QUEUE_ALL = "QUEUE_ALL";

    public static final String EXCHANGE_TOPIC = "EXCHANGE_TOPIC";

    public static final String ROUTING_KEY_TOPIC_ALL = "QUEUE_#";

    public static final String TOPIC_MAN = "topic.man";
    public static final String TOPIC_WOMAN = "topic.woman";
    public static final String TOPIC_ALL = "topic.#";

    public static final String QUEUE_FANOUT_ONE = "QUEUE_FANOUT_ONE";
    public static final String QUEUE_FANOUT_TWO = "QUEUE_FANOUT_TWO";
    public static final String QUEUE_FANOUT_THREE = "QUEUE_FANOUT_THREE";

    public static final String EXCHANGE_FANOUT = "EXCHANGE_FANOUT";

    /**
     * 死信接收队列
     */
    public static final String QUEUE_DLX = "QUEUE_DLX";
    
    /**
     * 死信接收队列2
     */
    public static final String QUEUE_DLX_2 = "QUEUE_DLX_2";
    
    /**
     * 死信延迟队列
     */
    public static final String QUEUE_DLX_DEALY = "QUEUE_DLX_DEALY";
    
    /**
     * 死信延迟队列2
     */
    public static final String QUEUE_DLX_DEALY_2 = "QUEUE_DLX_DEALY_2";

    /**
     * 死信队列转发队列
     */
    public static final String QUEUE_DLX_REDIRECT = "QUEUE_DLX_REDIRECT";

    public static final String EXCHANGE_DLX = "EXCHANGE_DLX";
    
    public static final String EXCHANGE_DELAY = "EXCHANGE_DELAY";

    public static final String EXCHANGE_DLX_REDIRECT = "EXCHANGE_DLX_REDIRECT";

    public static final String ROUTING_KEY_DLX = "ROUTING_KEY_DLX";
    
    public static final String ROUTING_KEY_DLX_2 = "ROUTING_KEY_DLX_2";
    
    public static final String ROUTING_KEY_DLX_DELAY = "ROUTING_KEY_DLX_DELAY";
    
    public static final String ROUTING_KEY_DLX_DELAY_2 = "ROUTING_KEY_DLX_DELAY_2";

    public static final String ROUTING_KEY_DLX_REDIRECT = "ROUTING_KEY_DLX_REDIRECT";

}
