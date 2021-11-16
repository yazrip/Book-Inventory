package com.example.book_inventory.service;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookServiceDbImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Transactional
    @Override
    public Book addBook(Book book) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        book.setId(uuid);
        bookRepo.addBook(book.getId(), book.getTitle().toLowerCase(), book.getAuthor(), book.getYear(), book.getPublisher(), book.getPrice(), book.getStock());
        return book;
    }

    @Transactional
    @Override
    public void deleteBook(String id) {
        bookRepo.deleteBook(id);
    }

    @Transactional
    @Override
    public List<Book> getAllBook() {
        return bookRepo.getAllBook();
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        bookRepo.updateBook(book.getId(), book.getTitle(), book.getAuthor(), book.getYear(), book.getPublisher(), book.getPrice(), book.getStock());
    }
    @Transactional
    @Override
    public Book getBookById(String id) {
        return bookRepo.getBookById(id).get(0);
    }

    @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> titleFilter = bookRepo.getAllBook();
        return titleFilter.stream().filter(x -> x.getTitle().equals(title.toLowerCase()))
                .collect(Collectors.toList());

    }


}
