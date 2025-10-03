package com.spring.Producer.Microservice.service;

import com.spring.core.library.ProductCreatedEvent;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String createProduct(Product product) throws ExecutionException, InterruptedException {
        String productId = UUID.randomUUID().toString();

        ProductCreatedEvent productCreatedEvent =
                new ProductCreatedEvent(productId,
                        product.getTitle(),product.getQuantity(),product.getPrice());
        SendResult<String,ProductCreatedEvent> result =
                kafkaTemplate.send("product-created-events-topic",productId,productCreatedEvent).get();

        logger.info("Partition "+result.getRecordMetadata().partition());
        logger.info("Offset "+result.getRecordMetadata().offset());
        logger.info("Time "+result.getRecordMetadata().hasTimestamp());
        logger.info("Returning product Id");
        return productId;
    }


}
