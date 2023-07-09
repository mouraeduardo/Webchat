package com.projeto.dois.webChat.controllers;

import com.projeto.dois.webChat.models.DTOs.SendMessageDTO;
import com.projeto.dois.webChat.models.Message;
import com.projeto.dois.webChat.models.User;
import com.projeto.dois.webChat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private final MessageRepository repository;

    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-message")
    public ResponseEntity getAllMessages( ) {
        List<Message> messages = (List<Message>) repository.findAll();

        return ResponseEntity.ok(messages);
    }

    @GetMapping("/get-message")
    public ResponseEntity GetMessageById(){

        return ResponseEntity.ok("funciona");
    }

    @PostMapping("/send-message")
    public ResponseEntity SendMessage(@RequestBody @Validated SendMessageDTO data){

        Message message = new Message(data);

        repository.save(message);

        return ResponseEntity.ok().build();
    }
}
