package com.walkwind.boot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRabbit
@SpringBootApplication
public class BootSenior02RabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSenior02RabbitApplication.class, args);
    }

}
