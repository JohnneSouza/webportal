package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.exception.CustomerNotFound;
import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImp implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);
    private static final String CUSTOMER_NOT_FOUND = "Customer not found";

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer) {
        LOGGER.info("Saving customer [{}] into repository", customer.getId());
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> updateCustomer(Customer customer, String customer_id) {
        return findCustomerById(customer_id).doOnSuccess(updateCustomer -> {
            updateCustomer.setName(customer.getName());
            updateCustomer.setAddress(customer.getAddress());
            updateCustomer.setPhone(customer.getPhone());
            customerRepository.save(updateCustomer).subscribe();
        });
    }

    @Override
    public Mono<Customer> findCustomerById(String customer_id) {
        return customerRepository.findById(customer_id)
                .switchIfEmpty(Mono.error(new CustomerNotFound(CUSTOMER_NOT_FOUND)));
    }

    @Override
    public Mono<Customer> deleteCustomer(String customer_id) {
        return findCustomerById(customer_id).doOnSuccess(
                customer -> customerRepository.deleteById(customer_id))
                .doOnError(Throwable::getMessage);
    }
}
