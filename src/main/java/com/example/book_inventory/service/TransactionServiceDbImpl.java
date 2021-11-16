package com.example.book_inventory.service;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.entity.Transaction;
import com.example.book_inventory.entity.User;
import com.example.book_inventory.repo.BookRepo;
import com.example.book_inventory.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionServiceDbImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void createTransaction(Transaction transaction) {
        Book book = bookService.getBookById(transaction.getBookId());
        User user = userService.getUserById(transaction.getUserId());

        String uuid = UUID.randomUUID().toString().replace("-", "");
        transaction.setId(uuid);

        if (book.getStock() - transaction.getQuantity() < 0){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Product stock is not sufficient for your request ");
        }
        transaction.setTotalPrice(book.getPrice()*transaction.getQuantity());
        transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        book.decreaseStock(transaction.getQuantity());

        bookService.updateBook(book);
        transactionRepo.createTransaction(transaction.getId(), transaction.getQuantity(), transaction.getTotalPrice(), transaction.getTransactionDate(), book.getId(), user.getId());
    }


}
