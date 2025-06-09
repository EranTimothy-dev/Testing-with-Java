package com.orderingservicetest;

import com.orderingservice.Item;
import com.orderingservice.Order;
import com.orderingservice.OrderRepository;
import com.orderingservice.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    private String CUSTOMER_NAME = "John Doe";

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService underTest;

    @Captor
    private ArgumentCaptor<Order> orderCaptor;

    @Test
    void createOrderTest() {
        Order order = underTest.createOrder(CUSTOMER_NAME);
        verify(orderRepository).save(order);
        assertEquals(CUSTOMER_NAME, order.getCustomerName());
    }

    @Test
    void updateExistingOrderTest() {
        Item item = new Item("Item 1", 10.0);
        Order mockOrder = new Order(CUSTOMER_NAME);
        mockOrder.addItem(item);
        when(orderRepository.findById(mockOrder.getOrderId())).thenReturn(mockOrder);
        underTest.updateOrder(mockOrder);
        verify(orderRepository).findById(mockOrder.getOrderId());

        verify(orderRepository).save(orderCaptor.capture());
        Order result = orderCaptor.getValue();
        assertEquals(mockOrder.getOrderId(), result.getOrderId());
        assertEquals(mockOrder.getCustomerName(), result.getCustomerName());
        assertEquals(mockOrder.getItems().size(), result.getItems().size());
        assertEquals(item, result.getItems().get(0));
    }

    @Test
    void updateNonExistingOrderTest() {
        Order mockOrder = new Order(CUSTOMER_NAME);
        when(orderRepository.findById(mockOrder.getOrderId())).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> underTest.updateOrder(mockOrder));
        verify(orderRepository, never()).save(any(Order.class));
        verify(orderRepository).findById(mockOrder.getOrderId());
    }

    @Test
    void getExistingOrderTest() {
        Order mockOrder = new Order(CUSTOMER_NAME);
        when(orderRepository.findById(1)).thenReturn(mockOrder);
        assertEquals(mockOrder, underTest.getOrder(1));
        verify(orderRepository).findById(1);
    }

    @Test
    void getNonExistingOrderTest() {
        when(orderRepository.findById(1)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> underTest.getOrder(1));
        verify(orderRepository).findById(1);
    }
}
