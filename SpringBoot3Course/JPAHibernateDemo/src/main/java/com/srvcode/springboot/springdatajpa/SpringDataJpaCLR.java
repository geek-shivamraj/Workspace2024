package com.srvcode.springboot.springdatajpa;

import com.srvcode.springboot.jpa.JpaCourse;
import com.srvcode.springboot.jpa.JpaCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringDataJpaCLR implements CommandLineRunner {
    @Autowired
    private SpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new SpringDataJpaCourse(1, "Learn Google Cloud Spring Data JPA!", "Will Smith"));
        repository.save(new SpringDataJpaCourse(2, "Learn Azure Spring Data JPA!", "Jack"));
        repository.save(new SpringDataJpaCourse(3, "Learn DevOps Spring Data JPA!", "Jack"));

        repository.deleteById(1l);

        log.info("Spring Data JPA Fetched Record: {}", repository.findById(2l));
        log.info("Spring Data JPA Fetched Record: {}", repository.findById(3l));

        log.info("Spring Data JPA Fetched By Author: {}", repository.findByAuthor("Jack"));
        log.info("Spring Data JPA Fetched By Author: {}", repository.findByAuthor(""));
    }
}
