package com.srvcode.springboot.springdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "SpringDataJpaCourse")
public class SpringDataJpaCourse {

    @Id
    private long id;

    // @Column(name = "name") Not needed becoz of same column name
    private String name;

    // @Column(name = "author") Not needed becoz of same column name
    private String author;

    public SpringDataJpaCourse(){
    }

    public SpringDataJpaCourse(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
