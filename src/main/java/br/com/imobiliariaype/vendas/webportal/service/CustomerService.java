package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> saveCustomer(Customer customer);

    Mono<Customer> updateCustomer(Customer customer, String customer_id);

    Mono<Customer> findCustomerById(String customerName);

    Mono<Customer> deleteCustomer(String customer_id);

}
