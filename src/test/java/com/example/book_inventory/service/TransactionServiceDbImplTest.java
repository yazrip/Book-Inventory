package com.example.book_inventory.service;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.entity.Transaction;
import com.example.book_inventory.entity.User;
import com.example.book_inventory.repo.TransactionRepo;
import org.junit.jupiter.api.AfterEach;
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
public class TransactionServiceDbImplTest {

    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @BeforeEach
    public void reset() {
        transactionRepo.deleteAll();
    }

    @AfterEach
    public void reset2(){
        transactionRepo.deleteAll();
    }

    String uuid = UUID.randomUUID().toString().replace("-", "");
    Book book1 = new Book(uuid, "title1", "author", "year", "publisher", 5000, 20);
    User user1 = new User(uuid, "admin2", "0808080808", "Jl. Jalan", "admin","admin");

    @Test
    public void able_to_CreateOneTransaction() {
        bookService.addBook(book1);
        userService.addUser(user1);
        Transaction transaction = new Transaction(5, book1.getId(), user1.getId());
        transactionService.createTransaction(transaction);
        Long count = transactionRepo.count();
        assertEquals(1, count);
    }

    @Test
    public void able_to_CreateTwoTransaction() {
        bookService.addBook(book1);
        userService.addUser(user1);
        Transaction transaction1 = new Transaction(5, book1.getId(), user1.getId());
        Transaction transaction2 = new Transaction(10, book1.getId(), user1.getId());
        transactionService.createTransaction(transaction1);
        transactionService.createTransaction(transaction2);
        Long count = transactionRepo.count();
        assertEquals(2, count);
    }

    @Test
    public void findAll_shouldHaveSizeOfTwo_when_TwoTransactionsSaved() {
        bookService.addBook(book1);
        userService.addUser(user1);
        Transaction transaction1 = new Transaction(5, book1.getId(), user1.getId());
        Transaction transaction2 = new Transaction(5, book1.getId(), user1.getId());
        transactionService.createTransaction(transaction1);
        transactionService.createTransaction(transaction2);
        List<Transaction> transactions = transactionService.getAllTransaction();
        assertEquals(2, transactions.size());
    }

}
