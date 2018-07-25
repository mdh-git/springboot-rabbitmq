package com.mdh.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者2
 * Created by mdh on 2018/7/19.
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("topicMessagesReceiver  : " +msg);
    }
}
