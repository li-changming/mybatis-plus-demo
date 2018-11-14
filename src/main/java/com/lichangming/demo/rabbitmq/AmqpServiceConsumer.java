package com.lichangming.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lichangming
 * @Date: 2018/11/14 14:38
 */
@Component
public class AmqpServiceConsumer {
    private Logger logger = LoggerFactory.getLogger(AmqpServiceConsumer.class);
    private @Autowired
    AmqpTemplate amqpTemplate;

    public AmqpServiceConsumer() {
    }

    @RabbitListener(queues = {"com.queue.notify.hello"})
    public void receiveSmsCodeQueue(String message) {
        this.logger.info("------hello：消费者处理消息------");
        this.logger.debug(message);
        System.out.println(message);
    }
}
