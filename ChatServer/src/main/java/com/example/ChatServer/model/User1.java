package com.example.ChatServer.model;

import javax.persistence.*;

@Entity
@Table
public class User1 {

    @Id
    @SequenceGenerator(
            name = "user1_sequence",
            sequenceName = "user1_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user1_sequence"
    )
    private Long id;



    public User1() {};

    public User1(String userId, String destUserId, String message) {
        this.userId = userId;
        this.destUserId = destUserId;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getDestUserId() {
        return destUserId;
    }

    public String getMessage() {
        return message;
    }

    String userId;
    String destUserId;
    String message;
}
