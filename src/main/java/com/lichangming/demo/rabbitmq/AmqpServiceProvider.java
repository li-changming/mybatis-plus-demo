package com.lichangming.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lichangming
 * @Date: 2018/11/14 14:29
 */
@Service
public class AmqpServiceProvider {

    private @Autowired
    AmqpTemplate amqpTemplate;


    public void test(String message) {
        amqpTemplate.convertAndSend("com.queue.notify.hello", message);
    }

}

