package com.projeto.dois.webChat.models;

import jakarta.persistence.*;
import lombok.*;

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
    public int id;
    public String message;
    public int senderId;
    public int receiverId;

}
