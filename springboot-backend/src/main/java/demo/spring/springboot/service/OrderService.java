package demo.spring.springboot.service;

import demo.spring.springboot.dto.OrderDto;
import demo.spring.springboot.modelDao.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    public List<OrderDto> getAllOrders(UUID customerId);
    public OrderDto createOrder(Order order);
    public void deleteById(UUID id);
    public OrderDto updateOrder(Order order, UUID orderId);

}
