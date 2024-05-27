package demo.spring.springboot.serviceImp;

import demo.spring.springboot.Mapper.OrderToDto;
import demo.spring.springboot.dto.OrderDto;
import demo.spring.springboot.modelDao.Order;
import demo.spring.springboot.repository.OrderRepository;
import demo.spring.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> getAllOrders(UUID customerId) {
        if(customerId != null)
            return OrderToDto.toDto(orderRepository.findOrdersByCustomerId(customerId));
        return OrderToDto.toDto(orderRepository.findAll());
    }

    public OrderDto findById(UUID id) {
        Optional<Order> order = orderRepository.findById(id);
        return OrderToDto.toDto(order.get());
    }

    public OrderDto createOrder(Order order) {

        orderRepository.save(order);
        return OrderToDto.toDto(order);
    }

    public void deleteById(UUID id) {
        orderRepository.deleteById(id);
    }

    public OrderDto updateOrder(Order order, UUID orderId) {
        Order old_order = orderRepository.getById(orderId);
        old_order.setProduct(order.getProduct());
        old_order.setQuantity(order.getQuantity());
        orderRepository.save(old_order);
        return OrderToDto.toDto(old_order);
    }
}
