package com.srvcode.springboot.controller;

import com.srvcode.springboot.exceptions.UserNotFoundException;
import com.srvcode.springboot.model.User;
import com.srvcode.springboot.services.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceValidation {

    private UserDaoService service;
    public UserResourceValidation(UserDaoService service) {
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if(user == null)
            throw new UserNotFoundException("id:" + id);

        return user;
    }
    @PostMapping("/validUsers")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
