package com.security.testing.controller;

import com.security.testing.model.User;
import com.security.testing.repository.UserRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public Optional<User> info(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/search")
    public Optional<User> search(@RequestBody String query) {
        return userRepository.findByUsername(query);
    }
}
