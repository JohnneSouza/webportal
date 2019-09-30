package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Save a new customer", response = Customer.class)
    @PostMapping("/customers")
    public Mono<Customer> saveClient(@Valid @RequestBody Customer customer){
        LOGGER.info("Saving new Customer with id [{}]", customer.getId());
        return customerService.saveCustomer(customer);
    }

    @ApiOperation(value = "Find a customer")
    @GetMapping("/customers/{customer_id}")
    public Mono<Customer> findById(@PathVariable String customer_id){
        LOGGER.info("Looking for Customer with id [{}]", customer_id);
        return customerService.findCustomerById(customer_id);
    }

    @ApiOperation(value = "Delete a customer")
    @DeleteMapping("/customers/{customer_id}")
    public Mono<Customer> deleteCustomer(@PathVariable String customer_id){
        LOGGER.info("Delete customer with id [{}]", customer_id);
        return customerService.deleteCustomer(customer_id);
    }

}
