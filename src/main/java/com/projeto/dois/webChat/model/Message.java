package com.projeto.dois.webChat.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

import com.projeto.dois.webChat.model.DTOs.SendMessageDTO;

@Table(name="message")
@Entity(name="message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;

    @ManyToOne
    @JoinColumn(name = "senderId", referencedColumnName = "id")
    private User senderId;

    @ManyToOne
    @JoinColumn(name = "receiverId", referencedColumnName = "id")
    private User receiverId;
    private LocalDateTime sendDate;

    public Message(SendMessageDTO dto){
        this.message = dto.message();
        this.senderId = dto.senderId();
        this.receiverId = dto.receiverId();
    }
}
