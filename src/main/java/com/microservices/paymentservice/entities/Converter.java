package com.microservices.paymentservice.entities;

import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.model.PaymentMode;

import java.time.Instant;

public class Converter {

    public static TransactionDetails convertToEntity(Payment payment) {
        TransactionDetails productEntity = new TransactionDetails();
        productEntity.setOrderId(payment.getOrderId());
        productEntity.setPaymentMode(String.valueOf(payment.getPaymentMode()));
        productEntity.setReferenceNumber(payment.getReferenceNumber());
        productEntity.setPaymentDate(Instant.now());
        productEntity.setPaymentStatus("PAYMENT_SUCCESS");
        productEntity.setAmount(payment.getAmount());
        return productEntity;
    }

    public static Payment convertFromEntity(TransactionDetails transactionDetails) {
        Payment product = new Payment();
        product.setOrderId(transactionDetails.getOrderId());
        product.setAmount(transactionDetails.getAmount());
        product.setReferenceNumber(transactionDetails.getReferenceNumber());
        product.setPaymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()));
        return product;
    }
}
