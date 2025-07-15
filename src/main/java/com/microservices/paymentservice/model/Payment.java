package com.microservices.paymentservice.model;

import lombok.Data;

@Data
public class Payment {
    private long orderId;
    private long amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
}
