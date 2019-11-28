package br.com.imobiliariaype.vendas.webportal.repository;

import br.com.imobiliariaype.vendas.webportal.model.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, String> {

    @Override
    <S extends Message> Mono<S> save(S s);

    @Override
    Flux<Message> findAll();

    @Override
    Mono<Void> deleteById(String s);

    @Override
    Mono<Boolean> existsById(String s);
}
