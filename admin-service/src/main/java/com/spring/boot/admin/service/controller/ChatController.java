package com.spring.boot.admin.service.controller;

import com.spring.boot.admin.service.service.ChatProducerService;
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

    @GetMapping("/send-message")
    public String sendMessage(String message) throws ExecutionException, InterruptedException {
        chatProducerService.sendMessage(message);
        return "success!";
    }
}
