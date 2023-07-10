package com.projeto.dois.webChat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.dois.webChat.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
}
