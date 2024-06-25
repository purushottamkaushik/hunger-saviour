package org.hunger.saviour.portal.payment.service.config.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.payment.service.entities.OrderDto;
import org.hunger.saviour.portal.payment.service.entities.PaymentDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentsKafkaPublisher {


    private final KafkaTemplate<String,Object> kafkaTemplate;

    public void publishPaymentDetailsToOrder(OrderDto orderDto){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String result = objectMapper.writeValueAsString(orderDto);
            kafkaTemplate.send("orders",result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }



}
