package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryList implements IUserRepository {

    private List<User> users = new ArrayList<>();
    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
    @Override
    public List<User> getUsers() {
        return users;
    }

}
