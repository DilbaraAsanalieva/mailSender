package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailApplication {

    @Autowired
    private EmailSenderService emailSendService;

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {
        emailSendService.sendSimpleEmail("toEmail@gmail.com",
                "Hello from Java code",
                "This email was send with Java code");

    }

}
