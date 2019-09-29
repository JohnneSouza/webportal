package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.service.CustomerService;
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

    @PostMapping("customers")
    public Mono<Customer> saveClient(@Valid @RequestBody Customer customer){
        LOGGER.info("Saving new Customer with id [{}]", customer.getId());
        return customerService.saveCustomer(customer);
    }


}
