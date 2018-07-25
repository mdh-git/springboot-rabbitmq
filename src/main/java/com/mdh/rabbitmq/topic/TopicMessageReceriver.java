package com.mdh.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消费者1
 * Created by mdh on 2018/7/19.
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicMessageReceriver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("topicMessageReceiver  : " +msg);
    }
}
