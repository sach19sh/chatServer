package com.example.ChatServer.controller;

import com.example.ChatServer.model.User1;
import com.example.ChatServer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    private ChatService chatService;

    @Autowired
    public TestController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/get/{userId}")
    public String getAllMessages(@PathVariable String userId) {
        //call chatService to get all messages
        //userId = "user1";
        System.out.println("user GETTER IS "+userId);
        Optional<User1> res =  chatService.getAllMessages(userId);
        List<User1> ll =  res.isPresent()
                ? Collections.singletonList(res.get())
                : Collections.emptyList();
        User1 u = ll.get(0);
        String s = "id" + u.getId() + " user "+ u.getDestUserId()+ " message " + u.getMessage();
        return s;
    }

    @PostMapping("/post")
    public void sendMessage(@RequestBody User1 user){
        System.out.println("user IS "+user);
        System.out.println("user IS "+user.getMessage());
        chatService.sendMessage(user.getUserId(), user.getDestUserId(), user.getMessage());

    }
}
