package com.projeto.dois.webChat.controllers;

import com.projeto.dois.webChat.models.Message;
import com.projeto.dois.webChat.models.User;
import com.projeto.dois.webChat.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity getAllUsers( ) {
        List<Message> messages = (List<Message>) repository.findAll();

        return ResponseEntity.ok(messages);
    }

    public ResponseEntity SendMessage(@RequestBody @Validated Message data){

        repository.save(data);

        return ResponseEntity.ok().build();
    }
}
