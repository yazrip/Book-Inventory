package com.example.book_inventory.service;

import com.example.book_inventory.entity.User;
import com.example.book_inventory.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceDbImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Transactional
    @Override
    public User addUser(User user) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        user.setId(uuid);
        userRepo.addUser(user.getId(), user.getName().toLowerCase(), user.getPhone(), user.getAddress());
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(String id) {
        userRepo.deleteUser(id);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return userRepo.getAllUser();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepo.updateUser(user.getId(), user.getName(), user.getPhone(), user.getAddress());
    }

    @Transactional
    @Override
    public User getUserById(String id) {
        return userRepo.getUserById(id).get(0);
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> nameFilter = userRepo.getAllUser();
        return nameFilter.stream().filter(x -> x.getName().equals(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
