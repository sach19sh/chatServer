package com.example.ChatServer;

import com.example.ChatServer.model.User1;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ChatServiceConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ChatServiceRepository chatServiceRepository){
        return args -> {
            User1 m1 = new User1(
                    "user1",
                    "user2",
                    "hi from user1"
            );
            User1 m2 = new User1(
                    "user2",
                    "user1",
                    "hi from user2"
            );
            List<User1> messageList = new ArrayList();
            messageList.add(m1);
            messageList.add(m2);
            chatServiceRepository.saveAll(messageList);
        };
    }
}
