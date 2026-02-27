package com.example.E_Commerce_System_Backend.controller;

import com.example.E_Commerce_System_Backend.model.Order;
import com.example.E_Commerce_System_Backend.model.request.OrderRequest;
import com.example.E_Commerce_System_Backend.model.response.ApiResponse;
import com.example.E_Commerce_System_Backend.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        ApiResponse<List<Order>> response = ApiResponse.<List<Order>>builder()
                .message("Orders fetched successfully.")
                .payload(orders)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById(@PathVariable Integer id) {
        Order order = orderService.getOrderById(id);

        if (order != null) {
            ApiResponse<Order> response = ApiResponse.<Order>builder()
                    .message("Order with id " + id + " fetched successfully.")
                    .payload(order)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Order with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Order created successfully.")
                .payload(order)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> updateProductById(@RequestBody OrderRequest orderRequest, Integer id) {
        Order order = orderService.updateOrderById(orderRequest, id);

        if (order != null) {
            ApiResponse<Order> response = ApiResponse.<Order>builder()
                    .message("Order updated successfully.")
                    .payload(order)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Order with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> deleteOrderById(@PathVariable Integer id) {
        Order order = orderService.deleteOrderById(id);

        if (order == null) {
            ApiResponse<Order> response = ApiResponse.<Order>builder()
                    .message("Order with id " + id + " not found.")
                    .payload(null)
                    .status(HttpStatus.NOT_FOUND)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .message("Order with id " + id + " deleted successfully.")
                .payload(null)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
