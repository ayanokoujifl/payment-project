package com.ayanokoujifl.paymentservice.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ayanokoujifl.paymentservice.models.Payment;

@Service
public class PaymentService {

	private final static String BLUE_TEXT = "\u001B[34m";
	private final static String RESET_TEXT = "\u001B[0m";

	@Autowired
	private KafkaTemplate<String, Serializable> template;
	
	public void sendPayment(Payment payment) throws InterruptedException {
		System.out.println(BLUE_TEXT + "MENSAGEM RECEBIDA ::: " + payment.getId() + RESET_TEXT);
		Thread.sleep(1000); // Simula um atraso no processamento		
		System.out.println("Enviando pagamento...");
		template.send("payment-topic",payment);
	}

}
