package demo.spring.springboot.service;

import demo.spring.springboot.model.Order;
import demo.spring.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Order createOrder(Order order) {
        orderRepository.save(order);
        long orderId = order.getId();
        return orderRepository.findById(orderId).get();
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> findByCustomerId(Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    public Order updateOrder(Order order, long orderId) {
        Order old_order = orderRepository.getById(orderId);
        old_order.setProduct(order.getProduct());
        old_order.setQuantity(order.getQuantity());
        orderRepository.save(old_order);
        return old_order;

    }
}
