package com.srvcode.springboot.model;

import lombok.Data;

@Data
public class HelloWorldBean {

    private String messsage;
    public HelloWorldBean(String message) {
        this.messsage = message;
    }
}
