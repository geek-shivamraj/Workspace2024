package com.srvcode.springboot.controller;

import com.srvcode.springboot.exceptions.UserNotFoundException;
import com.srvcode.springboot.model.User;
import com.srvcode.springboot.services.UserDaoService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;

@RestController
public class HateoasUserController {

    private UserDaoService service;
    public HateoasUserController(UserDaoService service) {
        this.service = service;
    }
    @GetMapping("/hateoasUsers")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }
    @GetMapping("/hateoasUsers/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if(user == null)
            throw new UserNotFoundException("id:" + id);

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
}
