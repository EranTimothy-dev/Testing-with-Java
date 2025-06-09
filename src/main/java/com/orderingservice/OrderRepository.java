package com.orderingservice;

public interface OrderRepository {
    Order findById(int orderId);
    void save(Order order);
}
