package com.projeto.dois.webChat.controller;

import com.projeto.dois.webChat.model.Message;
import com.projeto.dois.webChat.model.User;
import com.projeto.dois.webChat.model.DTOs.GetMessagesDTO;
import com.projeto.dois.webChat.model.DTOs.SendMessageDTO;
import com.projeto.dois.webChat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
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

    /*@GetMapping("/messages-between-users")
    public ResponseEntity getMessagesBetweenUsers(@RequestBody @Validated GetMessagesDTO data) {
        List<Message> senderMessages = (List<Message>) repository.findMessageBySenderIdAndReceiverId(data.senderId(), data.receiverId());
        List<Message> receiverMessages = (List<Message>) repository.findMessageBySenderIdAndReceiverId(data.receiverId(), data.senderId());

        senderMessages.addAll(receiverMessages);

        return ResponseEntity.ok(senderMessages);
    }*/

    @PostMapping("/messages-between-users")
     public ResponseEntity<List<Message>> getMessagesBetweenUsers(@RequestBody GetMessagesDTO data) {    
        List<Message> senderMessages = (List<Message>) repository.findMessageBySenderIdAndReceiverId(data.senderId(), data.receiverId());
        List<Message> receiverMessages = (List<Message>) repository.findMessageBySenderIdAndReceiverId(data.receiverId(), data.senderId());

        senderMessages.addAll(receiverMessages);

        return ResponseEntity.ok(senderMessages);
    }

    @GetMapping("/get-message")
    public ResponseEntity GetMessageById(){

        return ResponseEntity.ok("funciona");
    }

    @PostMapping("/send-message")
    public ResponseEntity SendMessage(@RequestBody @Validated SendMessageDTO data){

        Message message = new Message(data);
        message.setSendDate(LocalDateTime.now());

        repository.save(message);

        return ResponseEntity.ok().build();
    }
}
