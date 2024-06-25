package org.hunger.saviour.portal.payment.service.repository;

import org.hunger.saviour.portal.payment.service.entities.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PaymentRepository extends CrudRepository<PaymentEntity , UUID> {
}
