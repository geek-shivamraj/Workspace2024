package com.srvcode.microservices.model;

import lombok.Data;

@Data
public class Limits {

    private int minimum;
    private int maximum;

    public Limits() {
    }

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
