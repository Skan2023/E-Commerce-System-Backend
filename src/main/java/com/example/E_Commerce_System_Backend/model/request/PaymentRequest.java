package com.example.E_Commerce_System_Backend.model.request;

import com.example.E_Commerce_System_Backend.model.Order;
import com.example.E_Commerce_System_Backend.model.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Integer orderId;
    private String paymentMethod;
    private PaymentStatus paymentStatus;
}
