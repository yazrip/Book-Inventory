package com.example.book_inventory.controller;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
    }

    @PutMapping("/book")
    public void editBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @GetMapping("/bookFilter/{title}")
    public List<Book> getBookByTitle(@PathVariable String title){
        return bookService.getBookByTitle(title);
    }
}
