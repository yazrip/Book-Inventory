package com.example.book_inventory.service;

import com.example.book_inventory.entity.Book;

import java.util.List;


public interface BookService {
    public Book addBook(Book book);
    public void deleteBook(String id);
    public List<Book> getAllBook();
    public void updateBook(Book book);
    public Book getBookById(String id);

    public List<Book> getBookByTitle(String title);
}
