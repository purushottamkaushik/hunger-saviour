package org.hunger.saviour.portal.order.service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class OrderEntity {

    @Id
    private UUID orderId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private OrderStatus orderStatus;
    private Double totalPrice;
    // List<RestaurantMenuEntity> menuItems;
    private UUID paymentId; // TO keep tables unrelational
    private Integer restaurantId; // To make tables unrelational
    private String restaurant_json;
    private UUID userId;
    private String transactionId;
}