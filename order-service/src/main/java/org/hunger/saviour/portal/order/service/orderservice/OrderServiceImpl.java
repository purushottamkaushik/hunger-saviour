package org.hunger.saviour.portal.order.service.orderservice;

import lombok.RequiredArgsConstructor;
import org.hunger.saviour.portal.order.service.entity.OrderDto;
import org.hunger.saviour.portal.order.service.entity.OrderEntity;
import org.hunger.saviour.portal.order.service.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{


    private OrderRepository orderRepository;
    @Override
    public void createOrder(OrderDto orderDto) {
        // save order information

        return;
    }
}
