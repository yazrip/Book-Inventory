package com.example.book_inventory.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles
public class UserTest {

    String uuid = UUID.randomUUID().toString().replace("-", "");

    @Test
    public void able_to_createAUser(){
        User user = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        assertNotNull(user);
    }

    @Test
    public void able_to_createAUser_with_given_information(){
        User expectedUser = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        User actualUser = new User(uuid, "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        assertEquals(expectedUser, actualUser);
    }
}
