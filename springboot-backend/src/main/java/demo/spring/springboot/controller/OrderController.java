package demo.spring.springboot.controller;


import demo.spring.springboot.Mapper.CustomerToDto;
import demo.spring.springboot.dto.OrderDto;
import demo.spring.springboot.modelDao.Order;
import demo.spring.springboot.serviceImp.OrderServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@Slf4j
public class OrderController {
    @Autowired
    private OrderServiceImp orderServiceImp;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(@RequestParam(defaultValue = "null") UUID customerId) {
        log.info("Get all orders Successfully");
        return ResponseEntity.ok().body(orderServiceImp.getAllOrders(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable UUID id) {
        log.info("Get order By Id");
        OrderDto orderDto = orderServiceImp.findById(id);
        return ResponseEntity.ok(orderDto);

    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody Order order) {
        log.info("Order save successfully");

        return ResponseEntity.ok().body(orderServiceImp.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable UUID id, @RequestBody Order orderDetails) {
        log.info("Order updated successfully");
        return ResponseEntity.ok(orderServiceImp.updateOrder(orderDetails,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        log.info("Order deleted successfully");
            orderServiceImp.deleteById(id);
            return ResponseEntity.ok().build();
    }

}
