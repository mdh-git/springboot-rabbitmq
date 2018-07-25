package com.mdh.rabbitmq.scene;

import com.mdh.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by mdh on 2018/7/19.
 */
@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.print("user receive : " + user.getName() + "/" + user.getPass());
    }
}
