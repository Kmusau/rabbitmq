package com.kmusau.rabbitmq.controller;

import com.kmusau.rabbitmq.dto.UserDto;
import com.kmusau.rabbitmq.publisher.RabbitMQJsonProducer;
import com.kmusau.rabbitmq.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @Autowired
    RabbitMQJsonProducer jsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ .. ");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDto userDto) {
        jsonProducer.sendJsonMessage(userDto);
        return ResponseEntity.ok("User body sent .. ");
    }

}
