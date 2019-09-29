package br.com.imobiliariaype.vendas.webportal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
public class Customer {

    @Id
    private String id;
    @NotNull(message = "name must not be null")
    private String name;
    @NotNull(message = "phone must not be null")
    private String phone;
    private Address address;

}
