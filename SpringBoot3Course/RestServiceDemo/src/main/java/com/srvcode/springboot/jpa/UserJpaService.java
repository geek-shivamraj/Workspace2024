package com.srvcode.springboot.jpa;

import com.srvcode.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserJpaService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findOne(int id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity;
    }

    public UserEntity save(UserEntity userEntity) {
        UserEntity userEntity1 = userRepository.save(userEntity);
        return userEntity1;
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
