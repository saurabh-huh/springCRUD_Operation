package demo.spring.springboot.controller;

import demo.spring.springboot.model.Customer;
import demo.spring.springboot.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

@Autowired
private CustomerService customerService;


// Save operation
@PostMapping("/customers")
public Customer saveCustomer(@Valid @RequestBody Customer customer) {
    return customerService.saveCustomer(customer);
}

//// Read operation
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList() {
        return customerService.fetchCustomerList();
    }

// Update operation
    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") Long customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

// Delete operation
    @DeleteMapping("/Customer/{id}")
    public String deleteCustomerById(@PathVariable("id")  Long customerId) {
        customerService.deleteCustomerById(customerId);
        return "Deleted Successfully";
    }
    @GetMapping("/Customer/{id}")
    public Customer fetchCustomerById(@PathVariable("id")  Long customerId) {
        return customerService.fetchCustomerById(customerId);
    }
}