package com.example.book_inventory.service;

import com.example.book_inventory.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public User addUser(User user);
    public void deleteUser(String id);
    public List<User> getAllUser();
    public void updateUser(User user);
    public User getUserById(String id);

    public List<User> getUserByName(String name);
}
