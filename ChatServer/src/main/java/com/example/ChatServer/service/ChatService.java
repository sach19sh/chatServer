package com.example.ChatServer.service;

import com.example.ChatServer.ChatServiceRepository;
import com.example.ChatServer.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

   private ChatServiceRepository chatServiceRepository;
   private static int count = 1;
   @Autowired
    public ChatService(ChatServiceRepository chatServiceRepository) {
       this.chatServiceRepository = chatServiceRepository;
   }


   public Optional<User1> getAllMessages(String userId) {
       Optional<User1> result =
               chatServiceRepository.findMessageModelByUserId(userId);
       return result;
   }

   public void sendMessage(String srcUserId, String destUserId, String message) {
       String id = srcUserId + count++;
       User1 m = new User1(
               srcUserId,
               destUserId,
               message
       );
       List<User1> messageList = new ArrayList();
       messageList.add(m);
       chatServiceRepository.saveAll(messageList);

       System.out.println("MESSAGE IS "+message);
       System.out.println("srcUserId IS "+srcUserId);
       System.out.println("destUserId IS "+destUserId);
   }

}
