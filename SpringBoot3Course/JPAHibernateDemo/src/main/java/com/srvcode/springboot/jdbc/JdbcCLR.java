package com.srvcode.springboot.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JdbcCLR implements CommandLineRunner {
    @Autowired
    private JdbcCourseRepository jdbcCourseRepository;

    @Override
    public void run(String... args) throws Exception {
        jdbcCourseRepository.insert(new JdbcCourse(1, "Learn Google Cloud Now!", "Will Smith"));
        jdbcCourseRepository.insert(new JdbcCourse(2, "Learn Azure Now!", "Jack"));
        jdbcCourseRepository.insert(new JdbcCourse(3, "Learn DevOps Now!", "Bell"));

        jdbcCourseRepository.deleteById(1);

        log.info("Jdbc Fetched Record: {}", jdbcCourseRepository.findById(2));
        log.info("Jdbc Fetched Record: {}", jdbcCourseRepository.findById(3));
    }
}
