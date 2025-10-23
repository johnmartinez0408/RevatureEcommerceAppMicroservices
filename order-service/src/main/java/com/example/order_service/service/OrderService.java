package com.example.order_service.service;

import com.example.order_service.entity.Order;
import com.example.order_service.model.OrderRequest;

import java.util.List;


public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    Long placeOrder(OrderRequest orderRequest);
}
