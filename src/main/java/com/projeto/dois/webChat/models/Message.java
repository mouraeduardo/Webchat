package com.projeto.dois.webChat.models;

import com.projeto.dois.webChat.models.DTOs.SendMessageDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Date sendDate;

    public Message(SendMessageDTO dto){
        this.message = dto.message();
        this.senderId = dto.senderId();
        this.receiverId = dto.receiverId();
        this.sendDate = dto.sendDate();
    }
}
