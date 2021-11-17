package com.example.book_inventory.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class TransactionTest {

    @Test
    public void able_to_createATransaction(){
        Transaction transaction = new Transaction(5, "123", "456");
        assertNotNull(transaction);
    }

    @Test
    public void able_to_createATransaction_with_given_information(){
        Transaction expectedTransaction = new Transaction(5, "123", "456");
        Transaction actualTransaction = new Transaction(5, "123", "456");
        assertEquals(expectedTransaction, actualTransaction);
    }
}
