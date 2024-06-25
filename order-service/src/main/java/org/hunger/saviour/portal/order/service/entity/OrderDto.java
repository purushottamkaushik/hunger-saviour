package org.hunger.saviour.portal.order.service.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

    private UUID orderId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private OrderStatus orderStatus;
    // List<RestaurantMenuEntity> menuItems;
    private UUID paymentId; // TO keep tables unrelational
    private Integer restaurantId; // To make tables unrelational
    private String restaurant_json;
    private UUID userId;
    private Double totalPrice;
    private String username;
    private String transactionId;
}