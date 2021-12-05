package com.spring.boot.user.service.controller;

import com.spring.boot.user.service.service.ChatProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/surabi-restaurant/chat")
public class ChatController {

    private final ChatProducerService chatProducerService;

    public ChatController(ChatProducerService chatProducerService) {
        this.chatProducerService = chatProducerService;
    }

    @GetMapping("/send-message-admin")
    public String sendMessage(String message) throws ExecutionException, InterruptedException {
        chatProducerService.sendMessage(message);
        return "success!";
    }

    @GetMapping("/send-message-user2")
    public String sendMessageUser2(String message) throws ExecutionException, InterruptedException {
        chatProducerService.sendMessageUser2(message);
        return "success!";
    }

    @GetMapping("/send-message-user1")
    public String sendMessageUser1(String message) throws ExecutionException, InterruptedException {
        chatProducerService.sendMessageUser1(message);
        return "success!";
    }
}
