package com.microservices.paymentservice.services;

import com.microservices.paymentservice.entities.Converter;
import com.microservices.paymentservice.entities.TransactionDetails;
import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.model.PaymentMode;
import com.microservices.paymentservice.model.PaymentResponse;
import com.microservices.paymentservice.repositories.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;

    public PaymentServiceImpl(TransactionDetailsRepository transactionDetailsRepository) {
        this.transactionDetailsRepository = transactionDetailsRepository;
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(long orderId) {
        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId);
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setPaymentId(transactionDetails.getTransactionId());
        paymentResponse.setPaymentStatus(transactionDetails.getPaymentStatus());
        paymentResponse.setPaymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()));
        paymentResponse.setAmount(transactionDetails.getAmount());
        paymentResponse.setPaymentDate(transactionDetails.getPaymentDate());
        paymentResponse.setOrderId(transactionDetails.getOrderId());
        return paymentResponse;
    }

    @Override
    public Long doPayment(Payment payment) {
        log.info("Recording payment details: {}", payment);

        TransactionDetails transactionDetails = Converter.convertToEntity(payment);
        transactionDetails = transactionDetailsRepository.save(transactionDetails);

        log.info("Transaction Completed with id: {}", transactionDetails.getTransactionId());
        return transactionDetails.getTransactionId();
    }
}
