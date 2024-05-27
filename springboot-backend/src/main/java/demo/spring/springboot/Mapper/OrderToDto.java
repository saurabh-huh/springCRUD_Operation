package demo.spring.springboot.Mapper;

import demo.spring.springboot.dto.OrderDto;
import demo.spring.springboot.modelDao.Order;

import java.util.List;

public class OrderToDto {
    public static OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setCustomer(order.getCustomer());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setProduct(order.getProduct());

        return orderDto;
    }
    public static List<OrderDto> toDto(List<Order> orderList){
        return orderList.stream().map(OrderToDto::toDto).toList();
    }
}
