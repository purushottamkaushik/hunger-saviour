package org.hunger.saviour.portal.payment.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    UUID paymentId;

    String paymentType;

    PaymentStatus paymentStatus;

    LocalDateTime paymentTimeStamp;

    String transactionId;
}
