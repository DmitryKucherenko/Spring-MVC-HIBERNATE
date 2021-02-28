package com.kucherenko.spring.spring_hibernate_mvc.dao;

import com.kucherenko.spring.spring_hibernate_mvc.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public List<User> search(String keyword);
    public User getUserById(int id);
    public void saveUser(User user);
    public void deleteUser(int id);
}
