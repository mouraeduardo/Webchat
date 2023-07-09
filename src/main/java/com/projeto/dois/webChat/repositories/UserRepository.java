package com.projeto.dois.webChat.repositories;

import com.projeto.dois.webChat.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
}
