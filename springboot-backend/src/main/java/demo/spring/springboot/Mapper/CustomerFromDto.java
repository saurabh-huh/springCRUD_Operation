package demo.spring.springboot.Mapper;

import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;

import java.util.List;

public class CustomerFromDto {
    public static Customer fromDto(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setId(customer.getId());
        customer.setEmail(customer.getEmail());

        return customer;
    }
    public static List<Customer> fromDto(List<CustomerDto> customerDtoList) {
        return customerDtoList.stream().map(CustomerFromDto::fromDto).toList();
    }
}
