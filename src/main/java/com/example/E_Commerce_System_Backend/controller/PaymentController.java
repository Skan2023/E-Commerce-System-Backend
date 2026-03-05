package com.example.E_Commerce_System_Backend.controller;

import com.example.E_Commerce_System_Backend.model.Payment;
import com.example.E_Commerce_System_Backend.model.request.PaymentRequest;
import com.example.E_Commerce_System_Backend.model.response.ApiResponse;
import com.example.E_Commerce_System_Backend.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Payment>>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();

        ApiResponse<List<Payment>> response = ApiResponse.<List<Payment>>builder()
                .message("Payments fetched successfully.")
                .payload(payments)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> getPaymentById(@PathVariable Integer id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                    .message("Payment with id " + id + " fetched successfully.")
                    .payload(payment)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                .message("Payment with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> createPayment(@RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.createPayment(paymentRequest);

        ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                .message("Payment created successfully.")
                .payload(payment)
                .status(HttpStatus.CREATED)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> updatePaymentById(@RequestBody PaymentRequest paymentRequest, @PathVariable Integer id) {
        Payment updatedPayment = paymentService.updatePaymentById(paymentRequest, id);

        if (updatedPayment != null) {
            ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                    .message("Payment with id " + id + " updated successfully.")
                    .payload(updatedPayment)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                .message("Payment with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> deletePaymentById(@PathVariable Integer id) {
        Payment payment = paymentService.deletePaymentById(id);

        if (payment != null) {
            ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                    .message("Payment with id " + id + " deleted successfully.")
                    .payload(null)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        ApiResponse<Payment> response = ApiResponse.<Payment>builder()
                .message("Payment with id " + id + " not found.")
                .payload(null)
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
