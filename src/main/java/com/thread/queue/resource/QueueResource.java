package com.thread.queue.resource;

import com.thread.queue.queueConfig.QueuePublisher;
import com.thread.queue.queueConfig.QueueReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueResource {

    @Autowired
    private QueuePublisher queuePublisher;
    @Autowired
    private QueueReceiver queueReceiver;
    @GetMapping("/start")
    public void publishToQueue(){
        try {
            System.out.println("Queue is getting ready");
            queuePublisher.publishToQueue();
            Thread.sleep(100);
            System.out.println("thread woken from sleep");
            //queueReceiver.receiveMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
