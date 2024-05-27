package demo.spring.springboot.dto;

import demo.spring.springboot.modelDao.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private UUID id;

    private String product;

    private long quantity;

    private Customer customer;
}
