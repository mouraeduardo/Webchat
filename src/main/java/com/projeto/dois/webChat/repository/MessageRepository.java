package com.projeto.dois.webChat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.dois.webChat.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
