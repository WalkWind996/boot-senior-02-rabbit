package com.walkwind.boot.service;

import com.walkwind.boot.bean.Person;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-25-18:07
 **/
@Service
public class PersonService {

    //监听walkwind队列
    @RabbitListener(queues = "walkwind")
    public void receive(Person person){
        System.out.println(person.toString()+"来了");
    }

    //获取walkwind队列消息对象
    @RabbitListener(queues = "walkwind")
    public void receive(Message message){
        //可获取消息头和消息体
        message.getMessageProperties().getHeaders();
        message.getBody();

    }
}
