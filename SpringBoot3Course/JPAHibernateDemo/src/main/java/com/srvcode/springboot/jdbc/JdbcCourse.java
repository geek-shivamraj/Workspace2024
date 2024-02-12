package com.srvcode.springboot.jdbc;

import lombok.Data;

@Data
public class JdbcCourse {
    private long id;
    private String name;
    private String author;

    public JdbcCourse(){
    }

    public JdbcCourse(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
