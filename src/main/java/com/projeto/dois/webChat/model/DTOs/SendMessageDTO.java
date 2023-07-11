package com.projeto.dois.webChat.model.DTOs;

import java.time.LocalDateTime;
import java.util.Date;

import com.projeto.dois.webChat.model.User;

public record SendMessageDTO(String message, User senderId, User receiverId){ }
