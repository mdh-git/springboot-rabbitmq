package com.mdh.rabbitmq.controller;

import com.mdh.rabbitmq.scene.UserSernder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mdh on 2018/7/19.
 */
@RestController
@RequestMapping("/user")
public class UserTest {

    @Autowired
    private UserSernder userSernder;

    /**
     * 实体类传输springboot完美的支持对象的发送和接收,不需要格外的配置
     * 实体类(必须序列化接口):
     */
    @PostMapping("/userTest")
    public void userTest(){
        System.out.println("开始！");
        userSernder.send();
        System.out.println("结束！");
    }
}
