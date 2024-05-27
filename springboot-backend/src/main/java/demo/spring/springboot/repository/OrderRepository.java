package demo.spring.springboot.repository;

import demo.spring.springboot.modelDao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findOrdersByCustomerId(UUID customerId);
}
