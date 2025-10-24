package com.example.order_service.service.impl;

import com.example.order_service.entity.Order;
import com.example.order_service.exception.OrderServiceException;
import com.example.order_service.external.client.ProductService;
import com.example.order_service.model.OrderRequest;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderServiceException("Order not found with id: "+ id, "ORDER_NOT_FOUND"));
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Long placeOrder(OrderRequest orderRequest) {

        //1 Reduce quantity by calling productService
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        //2 Save the order details to db and status as CREATED
        Order order = new Order();
        order.setAmount(orderRequest.getAmount());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(Instant.now());
        order.setOrderStatus("CREATED");
//        order.setPaymentMethod(orderRequest.getPaymentMethod());

        order = orderRepository.save(order);


        //3 call payment service to make payment. if success update status to PLACED

        //4 if payment failed, revert inventory changes, status to PAYMENT_FAILED

        return order.getOrderId();
    }
}
