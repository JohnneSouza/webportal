package br.com.imobiliariaype.vendas.webportal.service;

import br.com.imobiliariaype.vendas.webportal.model.Message;
import br.com.imobiliariaype.vendas.webportal.repository.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Mono<Message> addMessage(Message message){
        return messageRepository.save(message);
    }

    public Flux<Message> showMessages(){
        return messageRepository.findAll();
    }

    public String deleteMessge(String id){
        messageRepository.deleteById(id);

        return "Deletado";
    }
}
