package com.walkwind.boot;

import com.walkwind.boot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 1.使用rabbitTemplate收发消息
 * 2.切换消息转换器(序列化规则)
 * */
@SpringBootTest
class BootSenior02RabbitApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void userAmqpAdmin(){
        //declare声明的意思 使用amqpAdmin组件创建exchange
        amqpAdmin.declareExchange(new DirectExchange("amqp.exchange.direct",true,false));
        amqpAdmin.declareQueue(new Queue("amqp.queue"));
        amqpAdmin.declareBinding(new Binding("amqp.queue", Binding.DestinationType.QUEUE,"amqp.exchange.direct","amqp.routingRule",null));
    }

    /*
    * 将消息序列化后路由到队列中
    * 默认的MessageConverter会将消息体中的消息转换为byte数组
    * 切换默认的序列化规则需注入自定义配置类注入MessageConverter组件
    * */
    @Test
    void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Msg","Hello mq");
        map.put("data", Arrays.asList("张三",22,false));
//      rabbitTemplate.convertAndSend("exchange.direct","walkwind",map);
        rabbitTemplate.convertAndSend("exchange.direct","walkwind",new Person("哈哈哥",32,true));
        System.out.println("发送完成");
    }

    /*
     * 消费者从队列中接收消息
     * */
    @Test
    void contextLoads1() {
        Object walkwind = rabbitTemplate.receiveAndConvert("walkwind");
        System.out.println(walkwind);
    }

}
