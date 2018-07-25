package com.mdh.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产者
 * Created by mdh on 2018/7/19.
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String msg1 = "I am topic.message msg =======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange","topic.message",msg1);

        String msg2 = "I am topic.messages msg #######" ;
        System.out.println("sender 2 :" + msg2);
        this.rabbitTemplate.convertAndSend("exchange","topic.messages",msg2);
    }
}
