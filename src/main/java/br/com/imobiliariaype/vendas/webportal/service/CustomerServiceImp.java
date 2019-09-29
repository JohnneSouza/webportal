package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> updateCustomer(Customer customer, String customer_id) {

        return findCustomer(customer_id).doOnSuccess(updateCustomer -> {
            updateCustomer.setName(customer.getName());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setPhone(customer.getPhone());
            customerRepository.save(updateCustomer).subscribe();
        });
    }

    @Override
    public Mono<Customer> findCustomer(String customerName) {
        return null;
    }

    @Override
    public Mono<Customer> deleteCustomer(String customer_id) {
        return null;
    }
}
