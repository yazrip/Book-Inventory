package com.example.book_inventory.repo;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.entity.Transaction;
import com.example.book_inventory.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {
    @Modifying
    @Query(value = "insert into tr_transaction(id, quantity, total_price, transaction_date, book_id, user_id) values(:id, :quantity, :totalPrice, :transactionDate, :bookId, :userId)", nativeQuery = true)
    public void createTransaction(@Param("id") String id,
                                  @Param("quantity") Integer quantity,
                                  @Param("totalPrice") Integer totalPrice,
                                  @Param("transactionDate") Date transactionDate,
                                  @Param("bookId") String bookId,
                                  @Param("userId") String userId);

    @Modifying
    @Query(value = "select * from tr_transaction", nativeQuery = true)
    public List<Transaction> getAllTransaction();

    @Modifying
    @Query(value = "delete from tr_transaction", nativeQuery = true)
    public void deleteAll();
}
