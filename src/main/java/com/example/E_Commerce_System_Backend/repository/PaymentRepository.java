package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.Payment;
import com.example.E_Commerce_System_Backend.model.request.PaymentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentRepository {

    @Select("select * from payments")
    @Results(id = "paymentMapper", value = {
            @Result(property = "paymentId", column = "payment_id"),
            @Result(property = "orderId", column = "order_id",
                one = @One(select = "com.example.E_Commerce_System_Backend.repository.OrderRepository.findOrderById")
            ),
            @Result(property = "paymentMethod", column = "payment_method"),
            @Result(property = "paymentStatus", column = "payment_status"),
    })
    List<Payment> findAllPayments();

    @Select("""
            select * from payments WHERE payment_id = #{id}
            """)
    @ResultMap("paymentMapper")
    Payment findPaymentById(Integer id);

    @Select("""
            insert into payments(order_id, payment_method, payment_status)
            values (#{payment.orderId}, #{payment.paymentMethod}, #{payment.paymentStatus})
            returning *
            """)
    @ResultMap("paymentMapper")
    Payment createPayment(@Param("payment") PaymentRequest paymentRequest);

    @Select("""
            update payments set order_id=#{payment.orderId}, payment_method=#{payment.paymentMethod}, payment_status=#{payment.paymentStatus} where payment_id =#{id}
            returning *
            """)
    @ResultMap("paymentMapper")
    Payment updatePaymentById(@Param("payment") PaymentRequest paymentRequest, Integer id);

    @Select("""
            delete from payments where payment_id = #{id}
            returning *
            """)
    @ResultMap("paymentMapper")
    Payment deletePaymentById(Integer id);
}
