package com.projeto.dois.webChat.repository;

import com.projeto.dois.webChat.model.User;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.dois.webChat.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

    public Iterable<Message> findMessageBySenderIdAndReceiverId(User SenderId, User ReceiverId);

}
