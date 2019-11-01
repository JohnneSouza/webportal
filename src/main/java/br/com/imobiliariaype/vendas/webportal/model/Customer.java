package br.com.imobiliariaype.vendas.webportal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    @NotNull(message = "firstName must not be null")
    private String firstName;
    @NotNull(message = "lastName must not be null")
    private String lastName;
    private String id_document;
    private String phone;
    private Address address;
    private List<Property> propertyList = new ArrayList<>();

    public void addProperty(Property property){
        propertyList.add(property);
    }

}