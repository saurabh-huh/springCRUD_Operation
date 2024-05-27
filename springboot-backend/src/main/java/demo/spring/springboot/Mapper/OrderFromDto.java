package demo.spring.springboot.Mapper;

import demo.spring.springboot.dto.OrderDto;
import demo.spring.springboot.modelDao.Order;

import java.util.List;

public class OrderFromDto {
    public static Order fromDto(OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCustomer(orderDto.getCustomer());
        order.setQuantity(orderDto.getQuantity());
        order.setProduct(orderDto.getProduct());

        return order;
    }
    public static List<Order> fromDto(List<OrderDto> orderDtoList){
        return orderDtoList.stream().map(OrderFromDto::fromDto).toList();
    }
}
