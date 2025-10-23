package com.example.order_service.service.impl;

import com.example.order_service.entity.Order;
import com.example.order_service.model.OrderRequest;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        //1 Save the order details to db and status as CREATED

        Order order = new Order();
        order.setAmount(orderRequest.getAmount());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(Instant.now());
        order.setOrderStatus("CREATED");
        order.setPaymentMethod(orderRequest.getPaymentMethod());

        order = orderRepository.save(order);
        //2 Call product service to reduce inventory

        //3 call payment service to make payment. if success update status to PLACED

        //4 if payment failed, revert inventory changes, status to PAYMENT_FAILED

        return order.getOrderId();
    }
}
