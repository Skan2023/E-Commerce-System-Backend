package com.example.E_Commerce_System_Backend.service.implementation;

import com.example.E_Commerce_System_Backend.model.Payment;
import com.example.E_Commerce_System_Backend.model.request.PaymentRequest;
import com.example.E_Commerce_System_Backend.repository.PaymentRepository;
import com.example.E_Commerce_System_Backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImp implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImp(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAllPayments();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepository.findPaymentById(id);
    }

    @Override
    public Payment createPayment(PaymentRequest paymentRequest) {
        return paymentRepository.createPayment(paymentRequest);
    }

    @Override
    public Payment updatePaymentById(PaymentRequest paymentRequest, Integer id) {
        return paymentRepository.updatePaymentById(paymentRequest, id);
    }

    @Override
    public Payment deletePaymentById(Integer id) {
        return paymentRepository.deletePaymentById(id);
    }
}
