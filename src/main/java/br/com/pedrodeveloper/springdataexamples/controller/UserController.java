package br.com.pedrodeveloper.springdataexamples.controller;

import br.com.pedrodeveloper.springdataexamples.model.User;
import br.com.pedrodeveloper.springdataexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping
    @CrossOrigin
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
