package com.example.E_Commerce_System_Backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer paymentId;
    private Order orderId;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
}
