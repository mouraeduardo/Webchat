package com.projeto.dois.webChat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto.dois.webChat.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findUserByEmail(String email);
    public User findUserByUsername(String username);
    @Query("SELECT u FROM user u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<User> findByKeyword(@Param("keyword") String keyword);
}
