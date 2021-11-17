package com.example.book_inventory.service;

import com.example.book_inventory.dto.UserDetailsImpl;
import com.example.book_inventory.entity.User;
import com.example.book_inventory.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetailServiceDbImpl implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepo.findAccountByUsername(username).isPresent()) {
            throw new UsernameNotFoundException("Username not found!");
        }
        User user = userRepo.findAccountByUsername(username).get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));

        UserDetails userDetails = new UserDetailsImpl(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
    }
}