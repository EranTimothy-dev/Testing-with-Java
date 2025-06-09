package com.orderingservice;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    public Order createOrder(String customerName) {

        Order order = new Order(customerName);
        orderRepository.save(order);
        return order;
    }

    public void updateOrder(Order order) {

        if (orderRepository.findById(order.getOrderId()) != null) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }

    public Order getOrder(int orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found");
        }
        return order;
    }
}
