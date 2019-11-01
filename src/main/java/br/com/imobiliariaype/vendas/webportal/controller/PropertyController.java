package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Property;
import br.com.imobiliariaype.vendas.webportal.service.PropertyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @ApiOperation(value = "Save a new Property", response = Property.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/property")
    public Mono<Property> saveProperty(@Valid @RequestBody Property property){
        return propertyService.saveProperty(property);
    }

    @ApiOperation(value = "Find a property using the customer name", response = Property.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/property")
    public Flux<Property> findByCustomerName(){
        return propertyService.findAll();
    }


}
