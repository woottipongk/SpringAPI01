package com.example.work1.users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE MyUser u SET u.email = :email WHERE u.id = :id")
    void updateUserData(int id, String email);

}