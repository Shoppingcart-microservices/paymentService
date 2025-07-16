package com.microservices.paymentservice.model;

import lombok.Data;

import java.time.Instant;

@Data
public class PaymentResponse {
    private long paymentId;
    private String paymentStatus;
    private PaymentMode paymentMode;
    private long amount;
    private Instant paymentDate;
    private long orderId;
}
