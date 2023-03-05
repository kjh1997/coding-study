package com.whiteman.rabbitmqlistener.rabbitmq.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final EmailService emailService;

    @GetMapping("/test")
    public String testSender() {
        EmailMessage emailMessage = EmailMessage.builder()
                .to("aam42@naver.com")
                .subject("테스트 메일 제목")
                .message("테스트 메일 본문")

                .build();
        emailService.sendMail(emailMessage);
        return "success";
    }
}
