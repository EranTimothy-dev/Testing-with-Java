package com.orderingservice;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderId = 1;
    private final int orderId;
    private final String customerName;
    private final List<Item> items;

    public Order(String customerName) {
        this.orderId = nextOrderId++;
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
