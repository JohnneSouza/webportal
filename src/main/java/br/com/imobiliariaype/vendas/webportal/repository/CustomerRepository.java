package br.com.imobiliariaype.vendas.webportal.repository;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

    @Query("{'firstName': ?0}")
    Flux<Customer> findByFirstName(String firstName);

    @Query("{'lastName': ?0}")
    Flux<Customer> findByLastName(String lastName);

    @Override
    <S extends Customer> Mono<S> save(S s);

    @Override
    Flux<Customer> findAll();
}
