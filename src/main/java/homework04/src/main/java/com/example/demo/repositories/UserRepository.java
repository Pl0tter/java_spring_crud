package com.example.demo.repositories;

import com.example.demo.model.SqlTemplate;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConfigurationPropertiesScan("com.example.demo.model")
@AllArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbc;
    private final SqlTemplate sqlTemplate;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sqlTemplate.getSelectAllQuery(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(sqlTemplate.getInsertQuery(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(sqlTemplate.getDeleteQuery(), id);
    }

    public User update(User user) {
        jdbc.update(sqlTemplate.getUpdateQuery(), user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }
}
