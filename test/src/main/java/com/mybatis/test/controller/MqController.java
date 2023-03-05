package com.mybatis.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/mq")
public class MqController {
    private static final String EXCAHGE_NAME = "sample";
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/queue")
    public String samplePublish() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();

        System.out.println("?????");
        HashMap<String, String> mail = new HashMap<>();
        mail.put("to", "kjh19971002@gmail.com");
        mail.put("subject", "제목입니다.");
        mail.put("message", "내용입니다.");
        String data = om.writeValueAsString(mail);
        rabbitTemplate.convertAndSend(EXCAHGE_NAME, "routing.#", data);

        return "Message seding!";
    }

}
