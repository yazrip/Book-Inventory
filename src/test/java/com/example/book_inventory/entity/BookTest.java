package com.example.book_inventory.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class BookTest {

    String uuid = UUID.randomUUID().toString().replace("-", "");

    @Test
    public void able_to_create_book(){
        Book book = new Book(uuid, "title", "author", "year", "publisher", 5000, 20);
        assertNotNull(book);
    }

    @Test
    public void able_to_createABook_with_given_information(){
        Book expectedBook = new Book(uuid, "title", "author", "year", "publisher", 5000, 20);
        Book actualBook = new Book(uuid, "title", "author", "year", "publisher", 5000, 20);

        assertEquals(expectedBook, actualBook);
    }
}
