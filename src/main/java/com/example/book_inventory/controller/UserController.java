package com.example.book_inventory.controller;

import com.example.book_inventory.entity.User;
import com.example.book_inventory.security.JwtTokenUtil;
import com.example.book_inventory.service.UserDetailServiceDbImpl;
import com.example.book_inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailServiceDbImpl userDetailServiceDb;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody User user){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        //validate username dan password
        authenticationManager.authenticate((usernamePasswordAuthenticationToken));

        UserDetails userDetails = userDetailServiceDb.loadUserByUsername(user.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String, Object> tokenWrapper = new HashMap<>();
        tokenWrapper.put("token", token);

        return tokenWrapper;
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/user")
    public void editUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/userFilter/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

}
