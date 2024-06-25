package org.hunger.saviour.portal.payment.service.config.service;

import org.hunger.saviour.portal.payment.service.entities.OrderDto;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public interface PaymentService {

    public void createPayment(OrderDto orderDto);
}
