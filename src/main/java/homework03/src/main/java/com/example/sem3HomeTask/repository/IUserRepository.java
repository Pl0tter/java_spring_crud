package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;

import java.util.List;

public interface IUserRepository {
    void setUsers(List<User> users);

    void addUser(User user);

    List<User> getUsers();
}
