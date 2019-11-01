package br.com.imobiliariaype.vendas.webportal.repository;

import br.com.imobiliariaype.vendas.webportal.model.Customer;
import br.com.imobiliariaype.vendas.webportal.model.Property;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PropertyRepository extends ReactiveCrudRepository<Property, Customer> {

    @Override
    <S extends Property> Mono<S> save(S s);

    @Override
    Flux<Property> findAll();
}
