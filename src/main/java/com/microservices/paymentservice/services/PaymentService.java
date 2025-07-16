package com.microservices.paymentservice.services;

import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.model.PaymentResponse;

public interface PaymentService {

    Long doPayment(Payment payment);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
