package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers() ;
    User saveUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
}
