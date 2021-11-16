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

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    @Modifying
    @Query(value = "insert into mst_user(id, name, phone, address) values(:id, :name, :phone, :address)", nativeQuery = true)
    public void addUser(@Param("id") String id,
                        @Param("name") String name,
                        @Param("phone") String phone,
                        @Param("address") String address);

    @Modifying
    @Query(value = "select * from mst_user", nativeQuery = true)
    public List<User> getAllUser();

    @Modifying
    @Query(value = "delete from mst_user where id=:id", nativeQuery = true)
    public void deleteUser(@Param("id") String id);

    @Modifying
    @Query(value = "UPDATE mst_user SET name= :name, address= :address, phone= :phone WHERE id= :id", nativeQuery = true)
    public void updateUser(@Param("id") String id,
                           @Param("name") String name,
                           @Param("phone") String phone,
                           @Param("address") String address);

    @Modifying
    @Query(value = "select * from mst_user where id=:id", nativeQuery = true)
    public List<User> getUserById(@Param("id") String id);
}
