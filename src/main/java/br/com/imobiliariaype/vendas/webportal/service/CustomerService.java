package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Flux<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    public Flux<Customer> findByLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }
}
