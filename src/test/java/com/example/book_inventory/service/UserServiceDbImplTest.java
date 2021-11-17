package com.example.book_inventory.service;

import com.example.book_inventory.entity.User;
import com.example.book_inventory.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceDbImplTest {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;

    @BeforeEach
    public void reset(){ userRepo.deleteAll(); }

    String uuid = UUID.randomUUID().toString().replace("-", "");

    @Test
    public void able_to_CreateOneUser(){
        User user = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");

        userService.addUser(user);
        Long count = userRepo.count();
        assertEquals(1, count);
    }

    @Test
    public void able_to_CreateTwoUsers(){
        User user1 = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        User user2 = new User(uuid, "user", "0808080808", "Jl. Jalan", "user",
                "user");

        userService.addUser(user1);
        userService.addUser(user2);

        Long count = userRepo.count();
        assertEquals(2, count);
    }

    @Test
    public void findAll_shouldHaveSizeOfTwo_when_TwoUsersSaved(){
        User user1 = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        User user2 = new User(uuid, "user", "0808080808", "Jl. Jalan", "user",
                "user");

        userService.addUser(user1);
        userService.addUser(user2);
        List<User> users = userService.getAllUser();
        assertEquals(2, users.size());
    }

    @Test
    public void findAll_shouldReturnCorrectList_When_TwoUsersSaved(){
        User user1 = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        User user2 = new User(uuid, "user", "0808080808", "Jl. Jalan", "user",
                "user");

        userService.addUser(user1);
        userService.addUser(user2);

        List<User> expectedList = new ArrayList<>();
        expectedList.add(user1);
        expectedList.add(user2);

        assertEquals(expectedList, userService.getAllUser());
    }

    @Test
    public void getById_should_return_correctValue_when_UserIdIsExist() {
        User user = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        userService.addUser(user);
        User actualUser = userService.getUserById(user.getId());
        assertEquals(user, actualUser);
    }

    @Test
    public void getById_should_return_incorrectValue_when_UserIdIsNotExist(){
        User user = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        userService.addUser(user);
        assertThrows(ResponseStatusException.class, ()->{userService.getUserById("23423423423");});
    }
}
