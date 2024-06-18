package org.hunger.saviour.portal.order.service.repository;

import org.hunger.saviour.portal.order.service.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<OrderEntity, UUID> {
}