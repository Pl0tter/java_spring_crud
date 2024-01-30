package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryH2 implements IUserRepository {

    private final JdbcTemplate jdbc;

    public UserRepositoryH2(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void setUsers(List<User> users) {
        for (User user : users) {
            addUser(user);
        }
    }

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO userTable VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }
}
