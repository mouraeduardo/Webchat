package com.projeto.dois.webChat.repositories;

import com.projeto.dois.webChat.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
