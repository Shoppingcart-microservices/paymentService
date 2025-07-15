package com.microservices.paymentservice.services;

import com.microservices.paymentservice.model.Payment;
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
    public Long doPayment(Payment payment) {
        log.info("Recording payment details: {}", payment);

        return 0L;
    }
}
