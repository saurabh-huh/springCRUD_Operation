package demo.spring.springboot.Mapper;

import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;

import java.util.List;

public class CustomerToDto {

    public static CustomerDto toDto(Customer customer) {
        CustomerDto dto = new CustomerDto();

        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setId(customer.getId());
        dto.setEmail(customer.getEmail());

        return dto;
    }
    public static List<CustomerDto> toDto(List<Customer> customerList) {
        return customerList.stream().map(CustomerToDto::toDto).toList();

    }
}
