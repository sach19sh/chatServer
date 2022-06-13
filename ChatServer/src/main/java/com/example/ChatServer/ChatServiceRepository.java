package com.example.ChatServer;

import com.example.ChatServer.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChatServiceRepository extends JpaRepository<User1, Long> {

    @Query("SELECT u from User1 u where u.userId = ?1")
    Optional<User1> findMessageModelByUserId(String userId);


}
