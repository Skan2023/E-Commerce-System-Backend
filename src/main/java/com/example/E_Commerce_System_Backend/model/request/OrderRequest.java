package com.example.E_Commerce_System_Backend.model.request;

import com.example.E_Commerce_System_Backend.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Integer userId;
    private LocalDate orderDate;
    private OrderStatus status;
    private Double totalAmount;
}
