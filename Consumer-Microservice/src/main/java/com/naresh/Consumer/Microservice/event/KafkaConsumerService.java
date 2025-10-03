package com.naresh.Consumer.Microservice.event;

import com.spring.core.library.ProductCreatedEvent;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "product-created-events-topic")
public class KafkaConsumerService {

    @KafkaHandler
    public void handleNotification(ProductCreatedEvent productCreatedEvent){
        System.out.println(productCreatedEvent.getTitle());
    }

}
