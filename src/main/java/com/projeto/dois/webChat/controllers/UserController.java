package com.projeto.dois.webChat.controllers;

import com.projeto.dois.webChat.RequestEntitys.RequestUser;
import com.projeto.dois.webChat.models.User;
import com.projeto.dois.webChat.repositories.UserRepository;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping ("/login")
    @PermitAll
    public ResponseEntity Login(@RequestBody @Validated RequestUser data){

        User user = repository.findUserByEmail(data.email());
        System.out.println(user);
        if (user == null || !user.getPassword().equals(data.password()) ){
            return ResponseEntity.badRequest().build();
        }


        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PostMapping ("/register")
    @PermitAll
    public ResponseEntity Register(@RequestBody @Validated RequestUser data){

        User existUser = repository.findUserByEmail(data.email());

        if (!data.password().equals(data.confirmPassword()) || existUser != null){
            return ResponseEntity.badRequest().build();
        }

        User user = new User(data);

        System.out.println(user.getUsername() + " " + data.username());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        repository.save(user);

        return ResponseEntity.ok("Cadastrado com sucesso" + user.getPassword());
    }

    @GetMapping("/all-users")
    public ResponseEntity getAllUsers( ) {
        List<User> users = (List<User>) repository.findAll();

        return ResponseEntity.ok(users);
    }

}