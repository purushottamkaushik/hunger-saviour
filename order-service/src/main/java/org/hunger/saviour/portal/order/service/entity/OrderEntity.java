package org.hunger.saviour.portal.order.service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document
public class OrderEntity {

    @Id
    private UUID orderId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private OrderStatus orderStatus;
    // List<RestaurantMenuEntity> menuItems;
    private UUID paymentId; // TO keep tables unrelational
    private Integer restaurantId; // To make tables unrelational
    private String restaurant_json;
    private UUID userId;
}