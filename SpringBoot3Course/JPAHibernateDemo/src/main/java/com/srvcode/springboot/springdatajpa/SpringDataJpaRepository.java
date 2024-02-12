package com.srvcode.springboot.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<SpringDataJpaCourse, Long> {

    List<SpringDataJpaCourse> findByAuthor(String author);
}
