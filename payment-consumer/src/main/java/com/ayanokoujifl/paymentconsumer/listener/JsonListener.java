package com.ayanokoujifl.paymentconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ayanokoujifl.paymentconsumer.models.Payment;

@Component
public class JsonListener {

	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "kafkaListenerContainerFactory")
	public void antiFraud(@Payload Payment payment) throws Exception {
		System.out.println("Pagamento recebido: " + payment.toString());
		System.out.println("Validando fraude");
		Thread.sleep(2000);

		System.out.println("Pagamento validado com sucesso");
	}

	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "kafkaListenerContainerFactory")
	public void pdfGenerator() throws Exception {
		System.out.println("Gerando PDF");
		Thread.sleep(3000);

		System.out.println("PDF gerado com sucesso");
	}

	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "kafkaListenerContainerFactory")
	public void sendEmail() throws Exception {
		System.out.println("Enviando e-mail");
		Thread.sleep(4000);

		System.out.println("Email enviado com sucesso");
	}
}
