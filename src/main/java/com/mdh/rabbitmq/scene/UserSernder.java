package com.mdh.rabbitmq.scene;

import com.mdh.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mdh on 2018/7/19.
 */
@Component
public class UserSernder {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        User user = new User();
        user.setName("xyz");
        user.setPass("123456");
        System.out.print("User send :" + user.getName() + "/" + user.getPass());
        this.rabbitTemplate.convertAndSend("userQueue",user);
    }
}
