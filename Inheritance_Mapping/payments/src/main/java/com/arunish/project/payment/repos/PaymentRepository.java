package com.arunish.project.payment.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.arunish.project.payment.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
	
}
