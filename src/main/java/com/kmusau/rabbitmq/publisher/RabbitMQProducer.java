package com.kmusau.rabbitmq.publisher;

import com.kmusau.rabbitmq.configs.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    RabbitMQConfig rabbitMQConfig;

    public void sendMessage(String message) {
        log.info("Message sent :: {}", message);
        rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getRoutingKey(), message);
    }
}
