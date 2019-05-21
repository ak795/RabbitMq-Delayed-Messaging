package com.retryRabbitMq.retryRabbitMq.services;

import com.rabbitmq.client.Channel;
import com.retryRabbitMq.retryRabbitMq.pojos.Employee;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqListener {

    @RabbitListener(queues = "emp.queue")
    public void receive(final Message message) {
        System.out.println("Received message from : " + message.toString());
        System.out.println(message.getMessageProperties().getDelay());
    }
}
