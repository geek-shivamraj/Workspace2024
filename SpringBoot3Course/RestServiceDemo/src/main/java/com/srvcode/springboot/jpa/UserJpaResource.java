package com.srvcode.springboot.jpa;

import com.srvcode.springboot.exceptions.UserNotFoundException;
import com.srvcode.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

    private UserJpaService service;
    @Autowired
    private PostRepository postRepository;
    public UserJpaResource(UserJpaService service) {
        this.service = service;
    }

    @GetMapping("/jpa/users")
    public List<UserEntity> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<UserEntity> retrieveUser(@PathVariable int id) {
        Optional<UserEntity> user = service.findOne(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        EntityModel<UserEntity> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity savedUserEntity = service.save(userEntity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUserEntity.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<UserEntity> user = service.findOne(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post>  createPostForUser(@PathVariable int id, @RequestBody Post post) {
        Optional<UserEntity> user = service.findOne(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUserEntity(user.get());

        Post savedPost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
