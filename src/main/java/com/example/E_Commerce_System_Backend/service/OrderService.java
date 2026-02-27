package com.example.E_Commerce_System_Backend.service;

import com.example.E_Commerce_System_Backend.model.Order;
import com.example.E_Commerce_System_Backend.model.request.OrderRequest;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    Order createOrder(OrderRequest orderRequest);
    Order updateOrderById(OrderRequest orderRequest, Integer id);
    Order deleteOrderById(Integer id);
}
