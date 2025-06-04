package com.ayanokoujifl.paymentservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayanokoujifl.paymentservice.models.Payment;
import com.ayanokoujifl.paymentservice.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;

	@PostMapping
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment)throws Exception {
		service.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
