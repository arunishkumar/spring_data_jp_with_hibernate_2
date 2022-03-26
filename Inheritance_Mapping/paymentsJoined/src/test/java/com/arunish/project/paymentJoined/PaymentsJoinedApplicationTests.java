package com.arunish.project.paymentJoined;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arunish.project.paymentJoined.entities.Check;
import com.arunish.project.paymentJoined.entities.CreditCard;
import com.arunish.project.paymentJoined.repos.PaymentRepository;

@SpringBootTest
class PaymentsJoinedApplicationTests {

	@Autowired
	PaymentRepository repository;
	
	@Test
	void contextLoads() {
	}

	@Test
	void createPayment()
	{
		CreditCard ccObj=new CreditCard();
		ccObj.setId(12345);
		ccObj.setAmount(5000d);
		ccObj.setCardNumber("456784568");
		
		repository.save(ccObj);
		
		Check chObj=new Check();
		chObj.setId(56789);
		chObj.setAmount(8000d);
		chObj.setCheckNumber("985656754");
		
		repository.save(chObj);
	}	
}
