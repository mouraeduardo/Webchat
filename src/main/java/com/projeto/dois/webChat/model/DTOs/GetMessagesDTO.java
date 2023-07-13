package com.projeto.dois.webChat.model.DTOs;

import com.projeto.dois.webChat.model.User;

public record GetMessagesDTO(User senderId, User receiverId){ }
