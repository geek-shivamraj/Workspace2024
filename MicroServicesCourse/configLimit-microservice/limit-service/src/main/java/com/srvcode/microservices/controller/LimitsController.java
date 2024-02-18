package com.srvcode.microservices.controller;

import com.srvcode.microservices.configuration.Configuration;
import com.srvcode.microservices.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(config.getMinimum(), config.getMaximum());
    }
}
