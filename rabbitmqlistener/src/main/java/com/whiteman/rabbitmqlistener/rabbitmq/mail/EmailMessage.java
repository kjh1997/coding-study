package com.whiteman.rabbitmqlistener.rabbitmq.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage {
    private String to;
    private String subject;
    private String message;

    public String toString() {
        return "to : " + this.to + " | " + " subject : " + this.subject + " | " + " message : " + this.message;
    }
}
