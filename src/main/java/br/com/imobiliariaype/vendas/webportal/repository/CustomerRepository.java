package br.com.imobiliariaype.vendas.webportal.repository;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    @Override
    <S extends Customer> Mono<S> save(S s);

    @Override
    Mono<Customer> findById(String s);

    @Override
    Mono<Void> deleteById(String s);
}
