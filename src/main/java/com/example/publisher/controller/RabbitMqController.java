package com.example.publisher.controller;

import com.example.publisher.domain.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/book")
    public String sendUser(@RequestBody Book book) {
        rabbitTemplate.convertAndSend("mine.test.topic", "mine.topic.random.placeholder", book);
        return "book sent";
    }
}
