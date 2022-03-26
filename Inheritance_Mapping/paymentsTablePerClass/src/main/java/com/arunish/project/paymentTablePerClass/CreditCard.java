package com.arunish.project.paymentTablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class CreditCard extends Payment {

	
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
