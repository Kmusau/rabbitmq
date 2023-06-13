package com.kmusau.rabbitmq.publisher;

import com.kmusau.rabbitmq.configs.RabbitMQConfig;
import com.kmusau.rabbitmq.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonProducer {

    @Autowired
    RabbitMQConfig rabbitMQConfig;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(UserDto user) {
        log.info("Received user object :: {}", user);
        rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getJsonRoutingKey(), user);
    }
}
