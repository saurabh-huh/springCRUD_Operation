package demo.spring.springboot.serviceImp;


import demo.spring.springboot.Mapper.CustomerToDto;
import demo.spring.springboot.dto.CustomerDto;
import demo.spring.springboot.modelDao.Customer;
import demo.spring.springboot.repository.CustomerRepository;
import demo.spring.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;


@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto createCustomer(Customer customer) {
        customerRepository.save(customer);
        return CustomerToDto.toDto(customer);
    }

    public List<CustomerDto> fetchCustomerList(Pageable pageable) {
//        List<Customer> customerList = customerRepository.findAll();
            Page<Customer> customerPage = customerRepository.findAll((org.springframework.data.domain.Pageable) pageable);
            return customerPage.stream().map(customer -> CustomerToDto.toDto(customer)).toList();


//        return CustomerToDto.toDto(customerList);
    }

    public CustomerDto fetchCustomerById(UUID customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        CustomerDto dto = CustomerToDto.toDto(customer);
        return dto;
    }


    // Update operation

    public CustomerDto updateCustomer(Customer customer, UUID customerId) {
        Customer old_customer =  customerRepository.findById(customerId).get();
        old_customer.setEmail(customer.getEmail());
        old_customer.setFirstName(customer.getFirstName());
        old_customer.setLastName(customer.getLastName());
        customerRepository.save(old_customer);

        return CustomerToDto.toDto(old_customer);

    }

    // Delete operation
    public void deleteCustomerById(UUID customerId) {
        customerRepository.deleteById(customerId);

    }
}
