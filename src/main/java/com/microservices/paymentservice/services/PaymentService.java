package com.microservices.paymentservice.services;

import com.microservices.paymentservice.model.Payment;

public interface PaymentService {

    Long doPayment(Payment payment);
}
