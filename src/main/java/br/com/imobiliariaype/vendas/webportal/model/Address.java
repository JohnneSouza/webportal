package br.com.imobiliariaype.vendas.webportal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Address {

    private String street;
    private String number;
    private String zip;
    private String neighborhood;
    private String state;
    private String city;

}
