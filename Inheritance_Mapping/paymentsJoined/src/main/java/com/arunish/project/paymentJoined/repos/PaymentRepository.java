package com.arunish.project.paymentJoined.repos;

import org.springframework.data.repository.CrudRepository;

import com.arunish.project.paymentJoined.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	
	
}
