package com.srvcode.springboot.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class JpaCourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert (JpaCourse course) {
        entityManager.merge(course);
    }

    public JpaCourse findById (long id) {
        return entityManager.find(JpaCourse.class, id);
    }

    public void deleteById (long id) {
        JpaCourse course = entityManager.find(JpaCourse.class, id);
        entityManager.remove(course);
    }


}
