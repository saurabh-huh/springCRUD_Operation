package demo.spring.springboot.controller;

import demo.spring.springboot.Mapper.CustomerFromDto;
import demo.spring.springboot.Mapper.CustomerToDto;
import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;
import demo.spring.springboot.serviceImp.CustomerServiceImp;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody Customer customer) {
        log.info("Customer created successfully");
        return ResponseEntity.ok(customerServiceImp.createCustomer(customer));
    }
@GetMapping
    public ResponseEntity<List<CustomerDto>> fetchCustomerList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("List of customers fetched successfully");

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        List<CustomerDto> customerPage = customerServiceImp.fetchCustomerList(pageable);

        return ResponseEntity.ok(customerPage);
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