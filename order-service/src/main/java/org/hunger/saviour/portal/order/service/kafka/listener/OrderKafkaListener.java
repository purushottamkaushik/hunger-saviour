package org.hunger.saviour.portal.order.service.kafka.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.order.service.entity.OrderDto;
import org.hunger.saviour.portal.order.service.orderservice.OrderService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderKafkaListener {

    private final OrderService orderService;

    @KafkaListener(topics = "orders",groupId = "orders-group")
    public void recievePaymentDetails(String orderJson){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            OrderDto recievedDto = mapper.readValue(orderJson, OrderDto.class);
            orderService.createOrder(recievedDto);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
