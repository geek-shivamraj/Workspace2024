package com.srvcode.springboot.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class JdbcCourseRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY = "insert into jdbcCourse (id, name, author) values(?, ?, ?);";
    private static String DELETE_QUERY = "delete from jdbcCourse where id = ?";
    private static String SELECT_QUERY = "select * from jdbcCourse where id = ?";

    public JdbcCourse findById(long id) {
        log.debug("Fetching record id: " + id + " from jdbcCourse table.....");

        // ResultSet -> Bean => Row Mapper -> BeanPropertyRowMapper
        JdbcCourse jdbcCourse = springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(JdbcCourse.class),id);
        log.debug("Record id: "+ id +" fetched from jdbcCourse table successfully!!");
        return jdbcCourse;
    }

    public void insert(JdbcCourse jdbcCourse) {
        log.debug("Inserting record id: " + jdbcCourse.getId() + " to jdbcCourse table.....");
        springJdbcTemplate.update(INSERT_QUERY, jdbcCourse.getId(), jdbcCourse.getName(), jdbcCourse.getAuthor());
        log.debug("Record id: "+ jdbcCourse.getId() +" inserted into jdbcCourse table successfully!!");
    }

    public void deleteById(long id) {
        log.debug("Deleting record id: " + id + " from jdbcCourse table.....");
        springJdbcTemplate.update(DELETE_QUERY, id);
        log.debug("Record id: "+ id +" deleted from jdbcCourse table successfully!!");
    }

    public void insertOld() {
        log.debug("Inserting record to jdbcCourse table.....");
        springJdbcTemplate.update("insert into jdbcCourse (id, name, author) values(1, 'Learn AWS', 'Jack');");
        log.debug("Record inserted into jdbcCourse table successfully!!");
    }
}
