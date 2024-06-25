package org.hunger.saviour.portal.payment.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID paymentId;
    @Column(name = "username")
    String username;
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    //    OrderEntity order; // one order can have only one payment;
    @Column(name = "timestamp")
    LocalDateTime paymentTimeStamp;

    @Column(name = "transaction_id")
    String transactionId;
}
