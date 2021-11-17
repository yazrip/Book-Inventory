package com.example.book_inventory.repo;

import com.example.book_inventory.entity.Book;
import com.example.book_inventory.entity.User;
import jdk.jfr.MetadataDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    public Optional<User> findAccountByUsername(String username);

    @Modifying
    @Query(value = "insert into mst_user(id, name, phone, address, username, password) values(:id, :name, :phone, :address, :username, :password)", nativeQuery = true)
    public void addUser(@Param("id") String id,
                        @Param("name") String name,
                        @Param("phone") String phone,
                        @Param("address") String address,
                        @Param("username") String username,
                        @Param("password") String password);

    @Modifying
    @Query(value = "select * from mst_user", nativeQuery = true)
    public List<User> getAllUser();

    @Modifying
    @Query(value = "delete from mst_user where id=:id", nativeQuery = true)
    public void deleteUser(@Param("id") String id);

    @Modifying
    @Query(value = "UPDATE mst_user SET name= :name, address= :address, phone= :phone, username= :username, password= :password WHERE id= :id", nativeQuery = true)
    public void updateUser(@Param("id") String id,
                           @Param("name") String name,
                           @Param("phone") String phone,
                           @Param("address") String address,
                           @Param("username") String username,
                           @Param("password") String password);

    @Modifying
    @Query(value = "select * from mst_user where id=:id", nativeQuery = true)
    public List<User> getUserById(@Param("id") String id);
}
