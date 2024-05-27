package demo.spring.springboot.service;

import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;


import java.util.List;
import java.util.UUID;

public interface CustomerService {
    public Customer createCustomer(Customer customer);
    public List<CustomerDto> fetchCustomerList();
    public CustomerDto fetchCustomerById(UUID customerId);
    public CustomerDto updateCustomer(Customer customer, UUID customerId);

}