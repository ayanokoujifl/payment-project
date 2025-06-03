package com.ayanokoujifl.paymentservice.services;

import org.springframework.stereotype.Service;

import com.ayanokoujifl.paymentservice.models.Payment;

@Service
public class PaymentService {

	private final static String BLUE_TEXT = "\u001B[34m";
	private final static String RESET_TEXT = "\u001B[0m";

	public void sendPayment(Payment payment) {
		System.out.println(BLUE_TEXT + "MENSAGEM RECEBIDA ::: " + payment.getId() + RESET_TEXT);
	}

}
