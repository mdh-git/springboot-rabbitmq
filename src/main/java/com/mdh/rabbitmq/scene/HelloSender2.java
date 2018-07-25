package com.mdh.rabbitmq.scene;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by mdh on 2018/7/19.
 */
@Component
public class HelloSender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendStr(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
