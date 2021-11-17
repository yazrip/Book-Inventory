package com.example.book_inventory.service;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.repo.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceDbImplTest {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookService bookService;

    @BeforeEach
    public void reset() {
        bookRepo.deleteAll();
    }

    String uuid = UUID.randomUUID().toString().replace("-", "");

    @Test
    public void able_to_CreateOneBook() {
        Book book = new Book(uuid, "title", "author", "year", "publisher", 5000, 20);
        bookService.addBook(book);
        Long count = bookRepo.count();
        assertEquals(1, count);
    }

    @Test
    public void able_to_CreateTwoBook() {
        Book book1 = new Book(uuid, "title1", "author", "year", "publisher", 5000, 20);
        Book book2 = new Book(uuid, "title2", "author", "year", "publisher", 5000, 20);
        bookService.addBook(book1);
        bookService.addBook(book2);
        Long count = bookRepo.count();
        assertEquals(2, count);
    }

    @Test
    public void findAll_shouldHaveSizeOfTwo_when_TwoBooksSaved() {
        Book book1 = new Book(uuid, "title1", "author", "year", "publisher", 5000, 20);
        Book book2 = new Book(uuid, "title2", "author", "year", "publisher", 5000, 20);
        bookService.addBook(book1);
        bookService.addBook(book2);
        List<Book> books = bookService.getAllBook();
        assertEquals(2, books.size());
    }

    @Test
    public void findAll_shouldReturnCorrectList_When_TwoBooksSaved(){
        Book book1 = new Book(uuid, "title1", "author", "year", "publisher", 5000, 20);
        Book book2 = new Book(uuid, "title2", "author", "year", "publisher", 5000, 20);
        bookService.addBook(book1);
        bookService.addBook(book2);

        List<Book> expectedList = new ArrayList<>();
        expectedList.add(book1);
        expectedList.add(book2);

        assertEquals(expectedList, bookService.getAllBook());
    }

    @Test
    public void getById_should_return_correctValue_when_BookIdIsExist() {
        Book book1 = new Book(uuid, "title1", "author", "year", "publisher", 5000, 20);
        bookService.addBook(book1);
        Book actualBook = bookService.getBookById(book1.getId());
        assertEquals(book1, actualBook);
    }
}
