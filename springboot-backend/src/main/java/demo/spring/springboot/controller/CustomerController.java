package demo.spring.springboot.controller;

import demo.spring.springboot.Mapper.CustomerFromDto;
import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;
import demo.spring.springboot.serviceImp.CustomerServiceImp;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@Slf4j
public class CustomerController {

@Autowired
private CustomerServiceImp customerServiceImp;


// Save operation
@PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        log.info("Customer created successfully");
        return ResponseEntity.ok(customerServiceImp.createCustomer(customer));
    }

//// Read operation
    @GetMapping
    public ResponseEntity<List<CustomerDto>> fetchCustomerList() {
        log.info("List of customers fetched successfully");
        return ResponseEntity.ok( customerServiceImp.fetchCustomerList());
    }

// Update operation
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody Customer customer, @PathVariable("id") UUID customerId) {
        log.info("Customer updated successfully");
        return ResponseEntity.ok( customerServiceImp.updateCustomer(customer, customerId));
    }

// Delete operation
    @DeleteMapping("/{id}")
    public Void deleteCustomerById(@PathVariable("id") UUID customerId) {
        customerServiceImp.deleteCustomerById(customerId);
        log.info("Customer deleted successfully");
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> fetchCustomerById(@PathVariable("id")  UUID customerId) {
        log.info("Customer fetched by id");
        return ResponseEntity.ok( customerServiceImp.fetchCustomerById(customerId));
    }
}