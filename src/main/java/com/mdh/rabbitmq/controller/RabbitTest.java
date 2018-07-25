package com.mdh.rabbitmq.controller;

import com.mdh.rabbitmq.callback.CallBackSender;
import com.mdh.rabbitmq.faount.FanoutSender;
import com.mdh.rabbitmq.scene.HelloSender1;
import com.mdh.rabbitmq.scene.HelloSender2;
import com.mdh.rabbitmq.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 *
 * Created by mdh on 2018/7/17.
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallBackSender callBackSender;

    /**
     * 最简单的hello生产和消费实现（单生产者和单消费者）
     */
    @PostMapping("/hello")
    public void hello(){
        System.out.println("开始！");
        helloSender1.send();
        System.out.println("结束！");
    }

    /**
     * 单生产者-多消费者
     */
    @PostMapping("/oneToMany")
    public void oneToMany(){
        System.out.println("开始！");
        for (int i = 0 ; i < 10 ; i++){
            helloSender1.send();
        }
        System.out.println("结束！");
    }

    /**
     * 多生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany(){
        System.out.println("开始！");
        for (int i = 0 ; i < 10 ; i++){
            helloSender1.sendStr("hellomsg" + i);
            helloSender2.sendStr("hellomsg" + i);
        }
        System.out.println("结束！");
    }


    /**
     * topic ExChange示例
     * topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
     * 首先对topic规则配置，这里使用两个队列来测试（也就是在Application类中创建和绑定的topic.message和topic.messages两个队列）
     * 其中topic.message的bindting_key为“topic.message”，topic.messages的binding_key为“topic.#”
     *
     * sender1 : I am topic.message msg =======
     * sender 2 :I am topic.messages msg #######
     * topicMessageReceiver  : I am topic.message msg =======
     * topicMessagesReceiver  : I am topic.message msg =======
     * topicMessagesReceiver  : I am topic.messages msg #######
     *
     *
     * sender1发送的消息,routing_key是“topic.message”，所以exchange里面的绑定的binding_key是“topic.message”，
     * topic.＃都符合路由规则;所以sender1发送的消息，两个队列都能接收到；
     *
     * sender2发送的消息，routing_key是“topic.messages”，所以exchange里面的绑定的binding_key只有topic.＃都符合路由规则;
     * 所以sender2发送的消息只有队列topic.messages能收到。
     */
    @PostMapping("/topicTest")
    public void topicTest(){
        topicSender.send();
    }

    /**
     * fanout ExChange示例
     *
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。
     *
     * 这里使用三个队列来测试（也就是在Application类中创建和绑定的fanout.A、fanout.B、fanout.C）这三个队列都和Application中创建的fanoutExchange转发器绑定。
     *
     * fanoutSender :hello i am mdh
     * FanoutReceiverA  : fanoutSender :hello i am mdh
     * FanoutReceiverB  : fanoutSender :hello i am mdh
     * FanoutReceiverC  : fanoutSender :hello i am mdh
     *
     * 由以上结果可知：就算fanoutSender发送消息的时候，指定了routing_key为”abcd.ee”，但是所有接收者都接受到了消息
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest(){
        fanoutSender.send();
    }

    /**
     * 带callback的消息发送
     *
     * 增加回调处理，这里不再使用application.properties默认配置的方式，会在程序中显示的使用文件中的配置信息。
     * 该示例中没有新建队列和exchange，用的是第5节中的topic.messages队列和exchange转发器。消费者也是第5节中的topicMessagesReceiver
     *
     * callbackSender : i am callback sender
     * callbackSender UUID: bca94dcf-5fe5-4cf7-95f1-8f90e50775c1
     * callbakck confirm: bca94dcf-5fe5-4cf7-95f1-8f90e50775c1
     * topicMessagesReceiver  : callbackSender : i am callback sender
     *
     * 从上面可以看出callbackSender发出的UUID，收到了回应，又传回来了。
     */
    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

}
