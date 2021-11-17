package com.example.book_inventory.repo;

import com.example.book_inventory.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {
    @Modifying
    @Query(value = "INSERT INTO mst_book(id, title, author, year, publisher, price, stock) values (:id, :title, :author, :year, :publisher, :price, :stock)", nativeQuery = true)
    public void addBook(@Param("id") String id,
                        @Param("title") String title,
                        @Param("author") String author,
                        @Param("year") String year,
                        @Param("publisher") String publisher,
                        @Param("price") Integer price,
                        @Param("stock") Integer stock);

    @Modifying
    @Query(value = "delete from mst_book where id=:id", nativeQuery = true)
    public void deleteBook(@Param("id") String id);

    @Modifying
    @Query(value = "select * from mst_book", nativeQuery = true)
    public List<Book> getAllBook();

    @Modifying
    @Query(value = "UPDATE mst_book SET title = :title, author = :author, year = :year, publisher = :publisher, price= :price, stock= :stock where id=:id", nativeQuery = true)
    public void updateBook(@Param("id") String id,
                         @Param("title") String title,
                         @Param("author") String author,
                         @Param("year") String year,
                         @Param("publisher") String publisher,
                         @Param("price") Integer price,
                         @Param("stock") Integer stock);

    @Modifying
    @Query(value = "select * from mst_book where id=:id", nativeQuery = true)
    public List<Book> getBookById(@Param("id") String id);

}
