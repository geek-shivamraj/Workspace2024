package com.srvcode.springboot.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
    private Integer id;

    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
