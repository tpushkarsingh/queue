package com.thread.queue.queueConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class QueuePublisher {

    @Autowired
    private  JmsTemplate jmsTemplate;
    public void publishToQueue(){
        System.out.println("Sending an message into the queue.");
        jmsTemplate.convertAndSend("OrderTransactionQueue",1);
    }
}
