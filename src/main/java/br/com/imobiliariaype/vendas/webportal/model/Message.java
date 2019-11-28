package br.com.imobiliariaype.vendas.webportal.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "message")
public class Message {

    @Id
    private String id;
    private String message;

    public Message(String message) {
        this.message = message;
    }
}
