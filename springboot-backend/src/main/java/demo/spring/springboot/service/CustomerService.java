package demo.spring.springboot.service;


import demo.spring.springboot.model.Customer;
import demo.spring.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {

        customerRepository.save(customer);
        return customer;
    }

    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

//    public Customer deleteCustomer(Customer customer) {
//
//        customerRepository.delete(customer);
//        return customer;
//    }

    public Customer fetchCustomerById(Long customerId) {
        return customerRepository.findById(customerId).get();
    }


    // Update operation

    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer old_customer =  customerRepository.findById(customerId).get();
        old_customer.setEmail(customer.getEmail());
        old_customer.setFirstName(customer.getFirstName());
        old_customer.setLastName(customer.getLastName());
        customerRepository.save(old_customer);
        return old_customer;

    }
    // Delete operation
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);

    }
}
