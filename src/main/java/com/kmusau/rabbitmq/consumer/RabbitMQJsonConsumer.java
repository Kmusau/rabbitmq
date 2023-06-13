package com.kmusau.rabbitmq.consumer;

import com.kmusau.rabbitmq.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJsonMessage(UserDto userDto) {
        log.info("Received user object :: {}", userDto);
    }
}
