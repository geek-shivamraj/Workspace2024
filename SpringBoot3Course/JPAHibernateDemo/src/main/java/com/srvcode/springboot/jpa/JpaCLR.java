package com.srvcode.springboot.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JpaCLR implements CommandLineRunner {
    @Autowired
    private JpaCourseRepository jpaCourseRepository;

    @Override
    public void run(String... args) throws Exception {
        jpaCourseRepository.insert(new JpaCourse(1, "Learn Google Cloud JPA!", "Will Smith"));
        jpaCourseRepository.insert(new JpaCourse(2, "Learn Azure JPA!", "Jack"));
        jpaCourseRepository.insert(new JpaCourse(3, "Learn DevOps JPA!", "Bell"));

        jpaCourseRepository.deleteById(1);

        log.info("Jpa Fetched Record: {}", jpaCourseRepository.findById(2));
        log.info("Jpa Fetched Record: {}", jpaCourseRepository.findById(3));
    }
}
