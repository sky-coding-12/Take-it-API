package com.example.final_take_it.repositiory;

import com.example.final_take_it.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepo extends JpaRepository<User, Long> {
    @Query("select u FROM User u WHERE u.phoneNumber =:phone")
    public List<User> getUserByPhone(@Param("phone") Long phone);
}
