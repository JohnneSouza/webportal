package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.model.Property;
import br.com.imobiliariaype.vendas.webportal.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Find a customer using firstName", response = Customer.class)
    @GetMapping("/customer/{firstName}")
    public Flux<Customer> findByFirstName(@PathVariable("firstName") String firstName){
        return customerService.findByFirstName(firstName);
    }

    @ApiOperation(value = "Save a new Customer", response = Customer.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/customer")
    public Mono<Customer> saveCustomer(@Valid @RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @ApiOperation(value = "Register a property to the customer", response = Customer.class)
    @PutMapping("/customer")
    public Mono<Customer> registerProperty(
            @RequestHeader("customer_id") String customer_id,
            @RequestBody @Valid Property property){
        return customerService.registerProperty(customer_id, property);
    }

    @GetMapping("/customer")
    public Flux<Customer> findAll(){
        return customerService.findAll();
    }

}