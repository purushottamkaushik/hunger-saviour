package org.hunger.saviour.portal.payment.service.config.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hunger.saviour.portal.payment.service.config.kafka.PaymentsKafkaPublisher;
import org.hunger.saviour.portal.payment.service.entities.OrderDto;
import org.hunger.saviour.portal.payment.service.entities.PaymentEntity;
import org.hunger.saviour.portal.payment.service.entities.PaymentStatus;
import org.hunger.saviour.portal.payment.service.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository   ;
    private final PaymentsKafkaPublisher kafkaPublisher ;
    @Override
    public void createPayment(OrderDto orderDto) {
        PaymentEntity paymentEntity = PaymentEntity.builder()
                .username(orderDto.getUsername())
                .paymentStatus(PaymentStatus.PAYMENT_SUCCESS)
                .transactionId(orderDto.getTransactionId())
                .paymentTimeStamp(LocalDateTime.now())
                .build();

        this.paymentRepository.save(paymentEntity);
        this.kafkaPublisher.publishPaymentDetailsToOrder(orderDto);


    }
}
