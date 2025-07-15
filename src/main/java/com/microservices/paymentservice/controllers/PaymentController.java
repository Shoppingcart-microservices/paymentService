package com.microservices.paymentservice.controllers;

import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@Log4j2
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<Long> doPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.doPayment(payment));
    }
}
