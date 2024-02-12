package com.srvcode.springboot.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "userEntity")
    @JsonIgnore
    private List<Post> posts;

    public UserEntity(){}
    public UserEntity(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
