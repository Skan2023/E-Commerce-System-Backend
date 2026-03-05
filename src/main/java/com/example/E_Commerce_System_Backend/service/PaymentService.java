package com.example.E_Commerce_System_Backend.service;

import com.example.E_Commerce_System_Backend.model.Payment;
import com.example.E_Commerce_System_Backend.model.request.PaymentRequest;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer id);
    Payment createPayment(PaymentRequest paymentRequest);
    Payment updatePaymentById(PaymentRequest paymentRequest, Integer id);
    Payment deletePaymentById(Integer id);
}
