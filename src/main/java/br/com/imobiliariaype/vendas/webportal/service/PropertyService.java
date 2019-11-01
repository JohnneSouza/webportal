package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.model.Property;
import br.com.imobiliariaype.vendas.webportal.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Mono<Property> saveProperty(Property property){
        return propertyRepository.save(property);
    }

    public Flux<Property> findAll(){
        return propertyRepository.findAll();
    }


}
