package com.whiteman.rabbitmqlistener.rabbitmq.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whiteman.rabbitmqlistener.rabbitmq.mail.EmailMessage;
import com.whiteman.rabbitmqlistener.rabbitmq.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.DataInput;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MQListener {
    private final EmailService emailService;

    @RabbitListener(queues = "basic")
    public void reciveMessage(final Message message) throws IOException {
        ObjectMapper om = new ObjectMapper();
        System.out.println("1 : " + message.getBody());

        System.out.println("2 : " + message.getClass());
        System.out.println("3 : " + message.toString());
        System.out.println("4 : " + message);
        String data = new String(message.getBody());

        EmailMessage emailMessage = om.readValue(data, EmailMessage.class);
        System.out.println(emailMessage.toString());
        emailService.sendMail(emailMessage);

        System.out.println(message.toString());
    }
}