package br.com.imobiliariaype.vendas.webportal.controller;

import br.com.imobiliariaype.vendas.webportal.model.Message;
import br.com.imobiliariaype.vendas.webportal.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v2")
public class ExampleController {


    private MessageService messageService;

    public ExampleController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/mensagem/{message}")
    public Mono<Message> addMessage(@PathVariable String message){

        return messageService.addMessage(new Message(message));
    }

    @GetMapping("/mensagem")
    public Flux<Message> showMessage(){
        return messageService.showMessages();
    }

}
