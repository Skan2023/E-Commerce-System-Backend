package com.example.E_Commerce_System_Backend.repository;

import com.example.E_Commerce_System_Backend.model.Order;
import com.example.E_Commerce_System_Backend.model.request.OrderRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderRepository {

    @Select("select * from orders")
    @Results(id = "orderMapper", value = {
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "userId", column = "user_id",
                one = @One(select = "com.example.E_Commerce_System_Backend.repository.UserRepository.findUserById")
            ),
            @Result(property = "orderDate", column = "order_date"),
            @Result(property = "totalAmount", column = "total_amount")
    })
    List<Order> findAllOrders();

    @Select("select * from orders WHERE order_id = #{id}")
    @ResultMap("orderMapper")
    Order findOrderById(Integer id);

    @Select("""
            insert into orders(user_id, order_date, status, total_amount)
            values (#{order.userId}, #{order.orderDate}, #{order.status}, #{order.totalAmount})
            returning *
            """)
    @ResultMap("orderMapper")
    Order insertOrder(@Param("order") OrderRequest orderRequest);

    @Select("""
            UPDATE orders
            SET user_id=#{order.userId},
                order_date=#{order.orderDate},
                status=#{order.status},
                total_amount=#{order.totalAmount}
            WHERE order_id=#{id}
            RETURNING *
            """)
    @ResultMap("orderMapper")
    Order updateProductById(@Param("order") OrderRequest orderRequest, Integer id);

    @Select("""
            DELETE FROM orders WHERE order_id=#{id}
            returning *
            """)
    Order deleteOrderById(Integer id);
}
