package br.com.imobiliariaype.vendas.webportal.exception;

public class CustomerNotFound extends RuntimeException{

    public CustomerNotFound(String message) {
        super(message);
    }
}
