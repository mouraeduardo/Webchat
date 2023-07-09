package com.projeto.dois.webChat.models.DTOs;

import com.projeto.dois.webChat.models.User;

import java.util.Date;

public record SendMessageDTO(String message, User senderId, User receiverId, Date sendDate){ }
