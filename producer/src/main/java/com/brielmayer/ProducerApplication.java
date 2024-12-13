package com.brielmayer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    private final JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend("DEV.QUEUE.1", "Message no. " + (i + 1), message -> {
                message.setStringProperty("JMSXGroupID", "key");
                return message;
            });
        }
    }
}