package com.brielmayer;

import jakarta.jms.Message;
import jakarta.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;

@Slf4j
@EnableJms
@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @JmsListener(destination = "DEV.QUEUE.1", containerFactory = "jmsListenerContainerFactory", concurrency = "5-10")
    public void receiveMessage(String s, Message message, Session session) {
        log.info("Message: {}, Session: {}", s, session);
    }

}