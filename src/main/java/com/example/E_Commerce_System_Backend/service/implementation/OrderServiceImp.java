package com.example.E_Commerce_System_Backend.service.implementation;

import com.example.E_Commerce_System_Backend.model.Order;
import com.example.E_Commerce_System_Backend.model.request.OrderRequest;
import com.example.E_Commerce_System_Backend.repository.OrderRepository;
import com.example.E_Commerce_System_Backend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        return orderRepository.insertOrder(orderRequest);
    }

    @Override
    public Order updateOrderById(OrderRequest orderRequest, Integer id) {
        return orderRepository.updateProductById(orderRequest, id);
    }

    @Override
    public Order deleteOrderById(Integer id) {
        Order order = orderRepository.deleteOrderById(id);

        if (order == null) {
            return null;
        }

        return order;
    }
}
