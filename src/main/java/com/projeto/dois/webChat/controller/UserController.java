package com.projeto.dois.webChat.controller;

import com.projeto.dois.webChat.RequestEntitys.RequestUser;
import com.projeto.dois.webChat.model.User;
import com.projeto.dois.webChat.repository.UserRepository;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/login")
    Principal getMet(Principal me){
        return me;
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
