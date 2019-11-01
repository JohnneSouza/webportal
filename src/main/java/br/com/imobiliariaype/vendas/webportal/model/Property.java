package br.com.imobiliariaype.vendas.webportal.model;

import br.com.imobiliariaype.vendas.webportal.model.details.Classification;
import br.com.imobiliariaype.vendas.webportal.model.details.ContractType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(collection = "properties")
public class Property {

    @NotNull(message = "Address must not be null")
    Address address;
    float value;
    Classification classification;
    ContractType contractType;
}
