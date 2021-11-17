package com.example.book_inventory.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles
public class UserTest {

    @Test
    public void able_to_createAUser(){
        User user = new User("123", "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        assertNotNull(user);
    }

    @Test
    public void able_to_createAnAccount_with_given_information(){
        User expectedUser = new User("123", "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        User actualUser = new User("123", "admin", "0808080808", "Jl. Jalan", "admin",
                "admin");
        assertEquals(expectedUser, actualUser);
    }
}
